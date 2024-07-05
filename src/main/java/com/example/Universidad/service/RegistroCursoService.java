package com.example.Universidad.service;

import com.example.Universidad.model.Curso;
import com.example.Universidad.model.RegistroCurso;
import com.example.Universidad.repository.RegistroCursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroCursoService {
    private RegistroCursoRepository registroCursoRepository;

    @Autowired

    public RegistroCursoService(RegistroCursoRepository registroCursoRepository) {
        this.registroCursoRepository = registroCursoRepository;
    }
    public void crearRegistroCurso(RegistroCurso registroCurso){
        this.registroCursoRepository.save(registroCurso);

    }
    public List<RegistroCurso> verRegistroCursos(){
        return  this.registroCursoRepository.findAll();
    }
}
