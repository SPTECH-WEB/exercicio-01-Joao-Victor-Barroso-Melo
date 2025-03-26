package com.example.Exercicio1.apiExercicio.repository;

import com.example.Exercicio1.apiExercicio.model.Fatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Integer> {
}
