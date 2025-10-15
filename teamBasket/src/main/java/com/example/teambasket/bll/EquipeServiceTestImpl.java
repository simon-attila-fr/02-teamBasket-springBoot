// Objectif : gérer les traitements métier.

package com.example.teambasket.bll;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.dto.EquipeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EquipeServiceTestImpl implements EquipeService {
    private Set<Equipe> equipes;
    private static int noEquipeIndex = 1;

    public EquipeServiceTestImpl() {
        // this.equipes = new HashSet<Equipe>();
        this.equipes = new HashSet<Equipe>();
        this.equipes.add(new Equipe(noEquipeIndex++, "U15F1"));
        this.equipes.add(new Equipe(noEquipeIndex++, "U16F1"));
        this.equipes.add(new Equipe(noEquipeIndex++,"U18F1"));
    }

    public void setEquipes(List<Equipe> equipes) {
        this.equipes = new HashSet<>(equipes);
    }

    @Override
    public List<Equipe> getEquipes() {
        return equipes.stream().toList();
    }

//    @Override
//    public Equipe addEquipe(EquipeDTO equipeDto) {
//        return null;
//    }

    @Override
    public Equipe addEquipe(EquipeDTO equipeDto) {
        Equipe newEquipe = new Equipe();
        newEquipe.setNoEquipe(noEquipeIndex++);
        BeanUtils.copyProperties(equipeDto, newEquipe);
        equipes.add(newEquipe);
        return newEquipe;
    }

//    @Override
//    public Equipe deleteEquipe(EquipeDTO equipeDto) {
//        return null;
//    }

    @Override
    public String deleteEquipe(int nbEquipe) {
        for(Equipe equipe : equipes) {
            if(equipe.getNoEquipe() == nbEquipe) {
                equipes.remove(equipe);
                break;
            }
        }
        return "Equipe no ${nbEquipe} a été supprimé";
    }

    @Override
    public Equipe findEquipe(int nbEquipe) {
        for(Equipe equipe : equipes) {
            if(equipe.getNoEquipe() == nbEquipe) {
                return equipe;
            }
        }
        return null;
    }
}
