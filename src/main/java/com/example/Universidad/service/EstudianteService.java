package com.example.Universidad.service;

import com.example.Universidad.model.Estudiante;
import com.example.Universidad.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    private EstudianteRepository estudianteRepository;

    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public void ingresarEstudiante(Estudiante estudiante){
        LocalDate fechaNacimiento = estudiante.getFechaNacimiento();
        LocalDate fechaActual = LocalDate.now();
        int edad = Period.between(fechaNacimiento, fechaActual).getYears();

        if (edad >= 18) {
            this.estudianteRepository.save(estudiante);
        }
        else {
            throw new IllegalArgumentException("El estudiante es menor de edad.");
      }

    }

    public List<Estudiante> verEstudiantes(){
        return  this.estudianteRepository.findAll();
    }


    public void EliminarEstudiante(Long id){
        Optional<Estudiante> etudianteEliminar= this.estudianteRepository.findById(id);
        if(etudianteEliminar.isPresent()){
            this.estudianteRepository.delete(etudianteEliminar.get());
            System.out.println("Se elimino el estudiante");
        }
        System.out.println("No se elimino el estudiante");
    }

}
