package com.example.Exercicio1.apiExercicio.service;

import com.example.Exercicio1.apiExercicio.model.Fatura;
import com.example.Exercicio1.apiExercicio.repository.FaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaturaService {
    private FaturaRepository faturaRepository;

    public FaturaService(FaturaRepository faturaRepository) {
        this.faturaRepository = faturaRepository;
    }

    public List<Fatura> getFaturas(){
        return faturaRepository.findAll();
    }

    public Fatura addFatura(Fatura fatura){
        return faturaRepository.save(fatura);
    }
}
