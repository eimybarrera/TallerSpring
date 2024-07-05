package com.example.Universidad.controller;

import com.example.Universidad.model.Profesor;
import com.example.Universidad.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/profesores")
public class ProfesorController {

    private ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @PostMapping()
    public ResponseEntity<String> ingresarProfesor( @RequestBody Profesor profesor){
        this.profesorService.ingresarProfesor(profesor);
        return  ResponseEntity.ok("Se creó el profesor");
    }
    @GetMapping()
    public List<Profesor> verProfesore(){
        return  this.profesorService.verProfesore();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> EliminarProfesor(@PathVariable("id") Long id){
      this.profesorService.EliminarProfesor(id);
        return  ResponseEntity.ok("Se elimino el profesor");
    }
}
