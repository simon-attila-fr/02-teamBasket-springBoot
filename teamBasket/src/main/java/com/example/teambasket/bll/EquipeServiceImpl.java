package com.example.teambasket.bll;


import com.example.teambasket.bo.Equipe;
import com.example.teambasket.dal.EquipeDAO;
import com.example.teambasket.dto.EquipeDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class EquipeServiceImpl implements EquipeService {
    private EquipeDAO equipeDAO;

    public EquipeServiceImpl(EquipeDAO equipeDAO) {
        this.equipeDAO = equipeDAO;
    }

    @Override
    public List<Equipe> getEquipes() {
        return equipeDAO.findAllEquipes();
    }

    @Override
    public String addEquipe(String nomEquipe) {
        Equipe newEquipe = new Equipe();
        BeanUtils.copyProperties(nomEquipe, newEquipe); // Est-ce que c'est toujours nécèssaire ?
        return equipeDAO.addEquipe(nomEquipe);
    }

    @Override
    public Equipe findEquipe(int nbEquipe) {
        return null;
    }

    @Override
    public Equipe findEquipeByName(String nomEquipe) {
        Optional<Equipe> foundEquipe = equipeDAO.findEquipeByNom(nomEquipe);
        if (foundEquipe.isPresent()) {
            return foundEquipe.get();
        }
        return null;
    }

    @Override
    public String deleteEquipe(int nbEquipe) {
        String result = equipeDAO.deleteEquipe(nbEquipe);
        return result;
    }


//    @Override
//    public Equipe addEquipe(EquipeDAO equipeDAO) {
//        return null;
//    }
}
