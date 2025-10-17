package com.example.teambasket.bll;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.bo.Joueur;
import com.example.teambasket.dto.JoueurDTO;

import java.util.List;

public interface JoueurService {
    public abstract List<Joueur> getJoueurs();

    Joueur addJoueur(JoueurDTO joueurDto);

    String deleteJoueur(int nbJoueur);
//
//    Joueur findJoeurById(int joueurId);
//
//    Joueur findJoueurByNom(String nomJoueur);
//    Joueur findJoueurByEmail(String emailJoueur);
//
//    Joueur findJoueurByEquipe(int nbEquipe);
}
