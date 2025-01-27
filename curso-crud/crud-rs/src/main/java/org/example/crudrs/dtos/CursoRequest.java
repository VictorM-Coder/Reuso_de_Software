package org.example.crudrs.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;

import java.util.List;

public record CursoRequest(
        @NotBlank(message = "O nome do curso não deve estar em branco")
        String nome,

        @NotBlank(message = "A descrição do curso não deve estar em branco")
        String descricao,

        @URL(message = "Formato de url inválido")
        @NotBlank(message = "A url não deve estar em branco") String url
) {
}
