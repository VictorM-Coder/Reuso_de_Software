package org.example.crudrs.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.crudrs.dtos.CursoPage;
import org.example.crudrs.dtos.CursoRequest;
import org.example.crudrs.mappers.CursoMapper;
import org.example.crudrs.models.Curso;
import org.example.crudrs.repositories.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CursoService {
    private final CursoRepository cursoRepository;

    public Curso create(CursoRequest request) {
        Curso cursoToSave = CursoMapper.requestToModel(request);
        return cursoRepository.save(cursoToSave);
    }

    public Curso getById(UUID id) {
        return findCursoByIdOrThrowEntityNoFound(id);
    }


    public Curso update(CursoRequest request, UUID id) {
        Curso cursoToUpdate = findCursoByIdOrThrowEntityNoFound(id);
        CursoMapper.RequestToModel(request, cursoToUpdate);
        return cursoRepository.save(cursoToUpdate);
    }

    public void delete(UUID id) {
        Curso cursoToDelete = findCursoByIdOrThrowEntityNoFound(id);
        cursoRepository.delete(cursoToDelete);
    }

    public CursoPage getAll(int pagina,  int tamanhoPagina) {
        PageRequest pageRequest = PageRequest.of(pagina-1, tamanhoPagina);
        Page<Curso> conteudo = cursoRepository.findAll(pageRequest);
        return new CursoPage(
                pagina,
                conteudo.getTotalPages(),
                conteudo.get().toList()
        );
    }

    private Curso findCursoByIdOrThrowEntityNoFound(UUID id) {
        return cursoRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Curso com o id " + id + " não encontrado"));
    }
}
