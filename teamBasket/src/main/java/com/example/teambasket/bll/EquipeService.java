// Couche métier

package com.example.teambasket.bll;

// Abstract interface, comme en TypeScript.

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.bo.Joueur;
import com.example.teambasket.dto.Joueurs_d_EquipeDTO;

import java.util.List;

public interface EquipeService {

    /* Retourne la liste de toutes les équipes */
    public abstract List<Equipe> getEquipes();

    public abstract String addEquipe(String equipeDAO);

    String deleteEquipe(int nbEquipe);

    Equipe findEquipe(int nbEquipe);

    Equipe findEquipeByName(String nomEquipe);

    List<Joueurs_d_EquipeDTO> listJoueursByEquipe(int nbEquipe);
}
