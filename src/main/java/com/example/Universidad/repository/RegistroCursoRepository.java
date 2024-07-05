package com.example.Universidad.repository;

import com.example.Universidad.model.RegistroCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroCursoRepository extends JpaRepository<RegistroCurso,Long> {
}
