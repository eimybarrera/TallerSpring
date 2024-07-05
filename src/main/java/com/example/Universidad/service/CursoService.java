package com.example.Universidad.service;

import com.example.Universidad.model.Curso;
import com.example.Universidad.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private CursoRepository cursoRepository;

    @Autowired
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void crearCurso(Curso curso){
        this.cursoRepository.save(curso);

    }
    public List<Curso> verCursos(){
        return  this.cursoRepository.findAll();
    }
}
