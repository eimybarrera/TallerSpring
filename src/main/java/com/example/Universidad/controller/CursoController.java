package com.example.Universidad.controller;

import com.example.Universidad.model.Curso;
import com.example.Universidad.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {
    private CursoService cursoService;

    @Autowired
    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping()
    public ResponseEntity<String> crearCurso(@RequestBody Curso curso){
         this.cursoService.crearCurso(curso);
         return  ResponseEntity.ok("Curso creado correctamente");
    }
    @GetMapping()
    public List<Curso> verCursos(){
        return this.cursoService.verCursos();
    }


}
