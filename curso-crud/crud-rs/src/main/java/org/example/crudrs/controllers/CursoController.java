package org.example.crudrs.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.crudrs.dtos.CursoPage;
import org.example.crudrs.dtos.CursoRequest;
import org.example.crudrs.models.Curso;
import org.example.crudrs.services.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cursos")
@CrossOrigin(origins = "*")
public class CursoController {
    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> post(@RequestBody @Valid CursoRequest request) {
        Curso response = cursoService.create(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> put(
            @RequestBody @Valid CursoRequest request,
            @PathVariable UUID id
    ) {
        Curso response = cursoService.update(request, id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getById(@PathVariable UUID id) {
        Curso response = cursoService.getById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping()
    public ResponseEntity<CursoPage> getAll(
            @RequestParam(defaultValue = "1") int pagina,
            @RequestParam(defaultValue = "8") int tamanhoPagina
    ) {
        CursoPage response = cursoService.getAll(pagina, tamanhoPagina);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Curso> delete(@PathVariable UUID id) {
        cursoService.delete(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
