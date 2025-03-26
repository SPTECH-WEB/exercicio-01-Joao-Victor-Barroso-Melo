package com.example.Exercicio1.apiExercicio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "faturas")
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Integer id;

    @NotBlank(message = "numero do cartao não deve ser vazio")
    @Digits(integer = 16, fraction = 4, message = "Cartão inválido")
    private String numeroCartao;

    @NotBlank(message = "nome não pode ser vazio")
    @Size(min = 3, max = 100, message = "O nome deve conter pelo menos 3 caracteres")
    private String nomeTitular;

    @NotBlank(message = "O valor não pode ser vazio")
    @Min(value = 10, message = "O valor deve ser maior que 10")
    @Max(value = 5000, message = "O valor deve ser menos que 5000")
    private Double valor;

    @NotBlank(message = "Data de pagamento não pode ser vazia")
    @FutureOrPresent(message = "A data deve ser atual ou futura")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "email inválido")
    private String emailContato;


}
