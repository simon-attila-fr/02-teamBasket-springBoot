package com.example.teambasket.dal;

import com.example.teambasket.bo.Joueur;

import java.util.List;

public interface JoueurDAO {
    public List<Joueur> getJoueurs();
    public String addJoueur(Joueur joueur);
}
