package com.example.Exercicio1.apiExercicio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Table(name = "fatura")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "numero do cartao não deve ser vazio")
    @Pattern(regexp = "\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}", message = "Cartão inválido")
    @JsonProperty("numeroCartao")
    private String numeroCartao;

    @NotBlank(message = "nome não pode ser vazio")
    @Size(min = 3, max = 100, message = "O nome deve conter pelo menos 3 caracteres")
    @JsonProperty("nomeTitular")
    private String nomeTitular;

    @NotNull(message = "O valor não pode ser vazio")
    @Min(value = 10, message = "O valor deve ser maior que 10")
    @Max(value = 5000, message = "O valor deve ser menos que 5000")
    @JsonProperty("valor")
    private Double valor;

    @NotNull(message = "Data de pagamento não pode ser vazia")
    @FutureOrPresent(message = "A data deve ser atual ou futura")
    @JsonProperty("dataPagamento")
    private LocalDate dataPagamento;

    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "email inválido")
    @JsonProperty("emailContato")
    private String emailContato;


}
