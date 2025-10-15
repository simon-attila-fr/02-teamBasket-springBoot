package com.example.teambasket.controllers;

import com.example.teambasket.bll.EquipeService;
import com.example.teambasket.dto.EquipeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.bll.EquipeServiceTestImpl;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeRestController {
    private final EquipeServiceTestImpl equipeServiceTestImpl;
    private final EquipeService equipeService;

    public EquipeRestController(EquipeServiceTestImpl equipeServiceTestImpl, EquipeService equipeService) {
        this.equipeServiceTestImpl = equipeServiceTestImpl;
        this.equipeService = equipeService;
    }

    @GetMapping
    public List<Equipe> getEquipes() {
        return equipeServiceTestImpl.getEquipes();
    }

    @PostMapping("/add")
    public ResponseEntity<Equipe> addEquipe(@RequestBody EquipeDTO equipeDto) {
        System.out.println("Adding equipe " + equipeDto );

        Equipe newEquipe = equipeService.addEquipe(equipeDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newEquipe);
    }

    @DeleteMapping("/delete/{nbEquipe}")

    public ResponseEntity<String> deleteEquipe(@PathVariable("nbEquipe") int nbEquipe) {
        System.out.println("Deleting equipe " + nbEquipe);
        String result  = equipeService.deleteEquipe(nbEquipe);
        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted equipe %d", nbEquipe));
    }

    @GetMapping("/getTeamById/{nbEquipe}")
    public ResponseEntity<Equipe> findEquipe(@PathVariable("nbEquipe") int nbEquipe) {
        System.out.println("Finding equipe " + nbEquipe);
        Equipe result = equipeService.findEquipe(nbEquipe);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
