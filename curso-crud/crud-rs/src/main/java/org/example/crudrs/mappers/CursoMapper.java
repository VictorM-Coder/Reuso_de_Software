package org.example.crudrs.mappers;

import org.example.crudrs.dtos.CursoRequest;
import org.example.crudrs.models.Curso;

public final class CursoMapper {
    private CursoMapper() {}

    public static Curso requestToModel(CursoRequest request) {
        Curso curso = new Curso();
        return RequestToModel(request, curso);
    }

    public static Curso RequestToModel(CursoRequest request, Curso curso) {
        curso.setNome(request.nome());
        curso.setDescricao(request.descricao());
        curso.setUrl(request.url());
        return curso;
    }
}
