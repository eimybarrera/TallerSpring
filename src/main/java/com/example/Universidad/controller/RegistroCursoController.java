package com.example.Universidad.controller;

import com.example.Universidad.model.Curso;
import com.example.Universidad.model.RegistroCurso;
import com.example.Universidad.repository.RegistroCursoRepository;
import com.example.Universidad.service.RegistroCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/registroCurso")
public class RegistroCursoController {

    private RegistroCursoService registroCursoService;
    @Autowired
    public RegistroCursoController(RegistroCursoService registroCursoService) {
        this.registroCursoService = registroCursoService;
    }


    @PostMapping()
    public ResponseEntity<String> crearRegistroCurso(@RequestBody RegistroCurso registroCurso){
        this.registroCursoService.crearRegistroCurso(registroCurso);
        return  ResponseEntity.ok("Registro del curso creado correctamente");
    }
    @GetMapping()
    public List<RegistroCurso> verRegistroCurso(){
        return this.registroCursoService.verRegistroCursos();
    }

}
