// Comment syncro l'objet (métier) avec la bdd.

package com.example.teambasket.dal;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.dto.Joueurs_d_EquipeDTO;

import java.util.List;
import java.util.Optional;

public interface EquipeDAO {
    public List<Equipe> findAllEquipes();
    public Optional<Equipe> findEquipeByNom(String nomEquipe);
    public String addEquipe(String nomEquipe);
    public String deleteEquipe(int nbEquipe);
    public List<Joueurs_d_EquipeDTO> findJoueursByEquipe(int nbEquipe);
}
