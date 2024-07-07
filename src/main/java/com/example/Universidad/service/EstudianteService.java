package com.example.Universidad.service;

import com.example.Universidad.model.Estudiante;
import com.example.Universidad.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        //Optional<Estudiante> etudianteIngresar= this.estudianteRepository.findById(estudiante.getId());

       // if(2024-(etudianteIngresar.get().getFechaNacimiento().getYear())>18){
            this.estudianteRepository.save(estudiante);
        //}
       // else {
            System.out.println("es menor de edad, pailas");
       // }

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
