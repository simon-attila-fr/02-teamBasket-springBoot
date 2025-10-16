package com.example.teambasket.controllers;

import com.example.teambasket.bll.EquipeService;
import com.example.teambasket.bll.EquipeServiceImpl;
import com.example.teambasket.dto.EquipeDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.teambasket.bo.Equipe;
//import com.example.teambasket.bll.EquipeServiceTestImpl;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeRestController {
//    private final EquipeServiceTestImpl equipeServiceTestImpl;
    private final EquipeServiceImpl equipeServiceImpl;
    private final EquipeService equipeService;

//    public EquipeRestController(EquipeServiceTestImpl equipeServiceTestImpl, EquipeService equipeService) {
//        this.equipeServiceTestImpl = equipeServiceTestImpl;
//        this.equipeService = equipeService;
//    }

    public EquipeRestController(EquipeServiceImpl equipeServiceImpl, EquipeService equipeService) {
        this.equipeServiceImpl = equipeServiceImpl;
        this.equipeService = equipeService;
    }

    @GetMapping
//    public List<Equipe> getEquipes() {
//        return equipeServiceTestImpl.getEquipes();
//    }
    public List<Equipe> getEquipes() {
        return equipeServiceImpl.getEquipes(); // Il faudrait faire référence à equipeService, on est d'acc ?
    }

    @PostMapping("/add")
    public ResponseEntity<String> addEquipe(@RequestBody EquipeDTO equipeDTO) {
        System.out.println("Adding equipe " + equipeDTO.getNomEquipe() );
        String newEquipe = equipeService.addEquipe(equipeDTO.getNomEquipe());

        return ResponseEntity.status(HttpStatus.CREATED).body(newEquipe);
    }

    @DeleteMapping("/delete/{nbEquipe}")
    public ResponseEntity<String> deleteEquipe(@PathVariable("nbEquipe") int nbEquipe) {
        System.out.println("Deleting equipe " + nbEquipe);
        String result  = equipeService.deleteEquipe(nbEquipe);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

//    public ResponseEntity<String> deleteEquipe(@PathVariable("nbEquipe") int nbEquipe) {
//        System.out.println("Deleting equipe " + nbEquipe);
//        String result  = equipeService.deleteEquipe(nbEquipe);
//        return ResponseEntity.status(HttpStatus.OK).body(String.format("Deleted equipe %d", nbEquipe));
//    }

    @GetMapping("/getTeamById/{nbEquipe}")
    public ResponseEntity<Equipe> findEquipe(@PathVariable("nbEquipe") int nbEquipe) {
        System.out.println("Finding equipe " + nbEquipe);
        Equipe result = equipeService.findEquipe(nbEquipe);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/getTeamByName/{nomEquipe}")
    public ResponseEntity<Equipe> findEquipeByName(@PathVariable("nomEquipe") String nomEquipe) {
        System.out.println("Search " + nomEquipe);
        Equipe result = equipeService.findEquipeByName(nomEquipe);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
