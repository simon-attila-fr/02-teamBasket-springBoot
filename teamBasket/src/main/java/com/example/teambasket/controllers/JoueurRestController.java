package com.example.teambasket.controllers;

import com.example.teambasket.bll.JoueurService;
import com.example.teambasket.bll.JoueurServiceImpl;
import com.example.teambasket.bo.Joueur;
import com.example.teambasket.dto.JoueurDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/joueurs")
public class JoueurRestController {
    // Je ne comprends pas cette partie.
    private final JoueurServiceImpl JoueurServiceImpl;
    private final JoueurService JoueurService;

    public JoueurRestController(JoueurServiceImpl JoueurServiceImpl, JoueurService JoueurService) {
        this.JoueurServiceImpl = JoueurServiceImpl;
        this.JoueurService = JoueurService;
    }

    @GetMapping
    public List<Joueur> getJoueurs()
    {
        System.out.println(JoueurServiceImpl.getJoueurs());
        return JoueurServiceImpl.getJoueurs();
    }

    @PostMapping("/add")
    public ResponseEntity<Joueur> addJoueur(@RequestBody JoueurDTO joueurDto) {
        System.out.println(joueurDto);

        Joueur newJoueur = JoueurService.addJoueur(joueurDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(newJoueur);
    }
}
