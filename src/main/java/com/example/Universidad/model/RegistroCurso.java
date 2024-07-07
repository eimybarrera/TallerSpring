package com.example.Universidad.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "registro_curso")
public class RegistroCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registro_curso_id")
    private Long id;

    @Column(name = "fecha_matricula")
    private LocalDate fechaMatricula;

    @Column(name = "fecha_desmatricula")
    private LocalDate fechaDesmatricula;

    @ManyToOne()
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne()
    @JoinColumn(name = "curso_id")
    private  Curso curso;


    public RegistroCurso() {
    }

    public RegistroCurso(Long id, LocalDate fechaMatricula, LocalDate fechaDesmatricula, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.fechaMatricula = fechaMatricula;
        this.fechaDesmatricula = fechaDesmatricula;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFechaMatricula() {
        return fechaMatricula;
    }

    public LocalDate getFechaDesmatricula() {
        return fechaDesmatricula;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
