package com.example.teambasket.dal;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.bo.Joueur;
import com.example.teambasket.dal.JoueurDAO;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@Repository
public class JoueurDAOImpl implements JoueurDAO {
    private final JdbcTemplate jdbcTemplate;
//    private final JoueurDAO joueurDAO;
    public JoueurDAOImpl(JdbcTemplate jdbcTemplate) {
//        this.joueurDAO = joueurDAO;
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public List<Joueur> getJoueurs() {
//        return joueurDAO.getJoueurs();
//    }
    @Override
    public List<Joueur> getJoueurs() {
        String sql = "SELECT idJoueur, nomJoueur, prenomJoueur, emailJoueur, nbEquipe FROM JOUEURS";
        return jdbcTemplate.query(sql, new JoueurRowMapper());
    }

    @Override
    public String addJoueur(Joueur joueur) {
//        return null;
        String sql = "INSERT INTO JOUEURS (nomJoueur, prenomJoueur, emailJoueur, nbEquipe) VALUES (?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
                    PreparedStatement ps = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
                    ps.setString(1, joueur.getNomJoueur());
                    ps.setString(2, joueur.getPrenomJoueur());
                    ps.setString(3, joueur.getEmailJoueur());
                    ps.setInt(4, joueur.getNbEquipe());
                    return ps;
                },  keyHolder
        );

        return keyHolder.getKey().toString();
    }

    class JoueurRowMapper implements RowMapper<Joueur> {
        @Override
        public Joueur mapRow(ResultSet rs, int RowNum) throws SQLException {
            Joueur joueur = new Joueur();
            joueur.setIdJoueur(rs.getInt("idJoueur"));
            joueur.setNomJoueur(rs.getString("nomJoueur"));
            joueur.setPrenomJoueur(rs.getString("prenomJoueur"));
            joueur.setEmailJoueur(rs.getString("emailJoueur"));
            joueur.setNbEquipe(rs.getInt("nbEquipe"));

            return joueur;
        }
    }
}
