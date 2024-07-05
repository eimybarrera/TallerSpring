package com.example.Universidad.service;

import com.example.Universidad.model.Estudiante;
import com.example.Universidad.model.Profesor;
import com.example.Universidad.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {
    private ProfesorRepository profesorRepository;

    @Autowired
    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }
    public void ingresarProfesor(Profesor profesor){
        this.profesorRepository.save(profesor);

    }

    public List<Profesor> verProfesore(){
        return  this.profesorRepository.findAll();
    }

    public void EliminarProfesor(Long id){
        Optional<Profesor> profesorEliminar= this.profesorRepository.findById(id);
        if(profesorEliminar.isPresent()){
            this.profesorRepository.delete(profesorEliminar.get());

        }
        System.out.println("se eliimo el profe");
    }
}
