package com.example.Universidad.controller;

import com.example.Universidad.model.Estudiante;
import com.example.Universidad.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {

    private EstudianteService estudianteService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping()
    public ResponseEntity<String> ingresarEstudiante(@RequestBody Estudiante estudiante){
        try {
            this.estudianteService.ingresarEstudiante(estudiante);
            return  ResponseEntity.ok("Se creó el estudiante");
        }catch (Exception e){
            return  ResponseEntity.ok("No se creó el estudiante because es menor de edad ");
        }

    }
    @GetMapping()
    public List<Estudiante> verEstudiantes(){
        return  this.estudianteService.verEstudiantes();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> EliminarEstudiante(@PathVariable("id") Long id){
         this.estudianteService.EliminarEstudiante(id);
        return ResponseEntity.ok("Se eliminó el estudiante");
    }
}
