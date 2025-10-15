package com.example.teambasket.bll;

import com.example.teambasket.bo.Joueur;
import com.example.teambasket.dto.JoueurDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JoueurServiceImpl implements JoueurService {
    private Set<Joueur> joueurs;
    private static int idJoueurIndex = 1;

    public JoueurServiceImpl() {
        this.joueurs = new HashSet<Joueur>();
        this.joueurs.add(new Joueur(
                idJoueurIndex++,
                "Zidane",
                "Zinedine",
                "zinedine.zidane@gmail.com",
                1
        ));
        this.joueurs.add(new Joueur(
                idJoueurIndex++,
                "Barthez",
                "Fabiane",
                "barthez.fabiane@gmail.com",
                1
        ));
        this.joueurs.add(new Joueur(
                idJoueurIndex++,
                "Deschamps",
                "Didier",
                "deschamps.didier@gmail.com",
                1
        ));
        this.joueurs.add(new Joueur(
                idJoueurIndex++,
                "Henry",
                "Thierry",
                "thierry.henry@gmail.com",
                1
        ));
    }

    @Override
    public List<Joueur> getJoueurs() {
        System.out.println(joueurs.stream().toList());
        return joueurs.stream().toList();
    }

    @Override
    public Joueur addJoueur(JoueurDTO joueurDTO) {
        Joueur newJoueur = new Joueur();
        newJoueur.setIdJoueur(idJoueurIndex++);
        BeanUtils.copyProperties(joueurDTO, newJoueur);
        joueurs.add(newJoueur);
        return newJoueur;
    }
}
