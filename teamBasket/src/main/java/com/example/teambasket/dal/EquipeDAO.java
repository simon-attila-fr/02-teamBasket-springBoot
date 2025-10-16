package com.example.teambasket.dal;

import com.example.teambasket.bo.Equipe;

import java.util.List;
import java.util.Optional;

public interface EquipeDAO {
    public List<Equipe> findAllEquipes();
    public Optional<Equipe> findEquipeByNom(String nomEquipe);
    public String addEquipe(String nomEquipe);
    public String deleteEquipe(int nbEquipe);
}
