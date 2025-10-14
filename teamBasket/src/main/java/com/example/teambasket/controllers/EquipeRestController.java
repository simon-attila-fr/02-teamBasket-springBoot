package com.example.teambasket.controllers;

import org.springframework.web.bind.annotation.*;

import com.example.teambasket.bo.Equipe;
import com.example.teambasket.bll.EquipeServiceTestImpl;

import java.util.List;

@RestController
@RequestMapping("/api/equipes")
public class EquipeRestController {
    private final EquipeServiceTestImpl equipeServiceTestImpl;

    public EquipeRestController(EquipeServiceTestImpl equipeServiceTestImpl) {
        this.equipeServiceTestImpl = equipeServiceTestImpl;
    }

    @GetMapping
    public List<Equipe> getEquipes() {
        return equipeServiceTestImpl.getEquipes();
    }



}
