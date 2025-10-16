package com.example.teambasket.dal;

import com.example.teambasket.bo.Equipe;
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
import java.util.Optional;

@Repository // Il syncro DAO avec la BDD
public class EquipeDAOImpl implements EquipeDAO {
    private JdbcTemplate jdbcTemplate;

    public EquipeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Equipe> findAllEquipes() {
        String sql = "SELECT noEquipe, nom FROM equipes";
        List<Equipe> equipes = jdbcTemplate.query(sql, new EquipeRowMapper());
        return equipes;
    }

    @Override
    public Optional<Equipe> findEquipeByNom(String nomEquipe) {
        String sql = "SELECT noEquipe, nom FROM equipes WHERE nom = ?";
        Equipe equipe = jdbcTemplate.queryForObject(sql, new EquipeRowMapper(), nomEquipe);

        return Optional.ofNullable(equipe);
    }

//    public String addEquipe(String nomEquipe) {
//        String sql = "INSERT INTO equipes (nom) VALUES (?)";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
//
//        jdbcTemplate.update( connection -> {
//            PreparedStatement ps = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
//            ps.setString(1, nomEquipe);
//            return ps;
//                },  keyHolder
//        );
//
//        int newId = keyHolder.getKey().intValue();
//        return String.valueOf(newId);
////        Equipe equipe = jdbcTemplate.update(sql, nomEquipe);
//    }

    public String addEquipe(String nomEquipe) {
        String sql = "INSERT INTO equipes (nom) VALUES (?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update( connection -> {
                    PreparedStatement ps = connection.prepareStatement( sql, Statement.RETURN_GENERATED_KEYS );
                    ps.setString(1, nomEquipe);
                    return ps;
                },  keyHolder
        );

        int newId = keyHolder.getKey().intValue();
        return String.valueOf(newId);
//        Equipe equipe = jdbcTemplate.update(sql, nomEquipe);
    }

    @Override
    public String deleteEquipe(int nbEquipe) {
        String sql = "DELETE FROM EQUIPES WHERE noEquipe = ?";
//        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(sql, nbEquipe);
        if (rowsAffected > 0) {
            return "Equipe deleted";
        } else {
            return "Equipe not deleted";
        }

    }

    class EquipeRowMapper implements RowMapper<Equipe> {
        @Override
        public Equipe mapRow(ResultSet rs, int RowNum) throws SQLException {
            Equipe equipe = new Equipe();
            equipe.setNoEquipe(rs.getInt("noEquipe"));
            equipe.setNomEquipe(rs.getString("nom"));

            return equipe;
        }
    }
}
