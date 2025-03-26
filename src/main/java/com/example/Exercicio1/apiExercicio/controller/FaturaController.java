package com.example.Exercicio1.apiExercicio.controller;

import com.example.Exercicio1.apiExercicio.model.Fatura;
import com.example.Exercicio1.apiExercicio.service.FaturaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faturas")
public class FaturaController {
    private final FaturaService faturaService;

    public FaturaController(FaturaService faturaService) {
        this.faturaService = faturaService;
    }

    @GetMapping
    public ResponseEntity<List<Fatura>> get(){
        return faturaService.getFaturas().isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.status(HttpStatus.OK).body(faturaService.getFaturas());
    }

    @PostMapping
    public ResponseEntity<Fatura> post(@Valid @RequestBody Fatura fatura){
        return ResponseEntity.status(201).body(faturaService.addFatura(fatura));
    }
}
