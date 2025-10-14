// Objectif : gérer les traitements métier.

package com.example.teambasket.bll;

import com.example.teambasket.bo.Equipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class EquipeServiceTestImpl implements EquipeService {
    private List<Equipe> equipes;

    public EquipeServiceTestImpl() {
        // this.equipes = new HashSet<Equipe>();
        this.equipes = new ArrayList<Equipe>();
        this.equipes.add(new Equipe(1, "U15F1"));
        this.equipes.add(new Equipe(2, "U16F1"));
        this.equipes.add(new Equipe(3,"U18F1"));

    }

    public List<Equipe> getEquipes() {

        return this.equipes;
    }
}
