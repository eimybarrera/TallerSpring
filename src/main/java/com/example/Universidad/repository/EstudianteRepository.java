package com.example.Universidad.repository;

import com.example.Universidad.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository  extends JpaRepository<Estudiante,Long> {
}
