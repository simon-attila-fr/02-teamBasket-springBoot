package com.example.teambasket.bll;

// Abstract interface, comme en TypeScript.

import com.example.teambasket.bo.Equipe;

import java.util.List;

public interface EquipeService {

    /* Retourne la liste de toutes les équipes */
    public abstract List<Equipe> getEquipes();

    public abstract String addEquipe(String equipeDAO);

    String deleteEquipe(int nbEquipe);

    Equipe findEquipe(int nbEquipe);

    Equipe findEquipeByName(String nomEquipe);
}
