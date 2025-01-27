package org.example.crudrs.dtos;

import org.example.crudrs.models.Curso;

import java.util.List;

public record CursoPage(
        int pagina,
        int totalPaginas,
        List<Curso> conteudo
) {
}
