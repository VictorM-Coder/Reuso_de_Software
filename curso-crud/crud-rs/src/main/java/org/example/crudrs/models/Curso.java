package org.example.crudrs.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.util.UUID;

@Data
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome do curso não deve estar em branco")
    private String nome;

    @NotBlank(message = "A descrição do curso não deve estar em branco")
    private String descricao;

    @URL(message = "Formato de url inválido")
    @NotBlank(message = "A url não deve estar em branco")
    private String url;
}
