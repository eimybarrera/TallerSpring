package com.example.Universidad.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "curso")
//@JsonIdentityInfo(scope = Curso.class, generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "id")

public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "curso_id")
    //@JsonIgnore
    private Long id;

    @Column(name = "nombre")
    private  String nombre;

    @Column(name = "descripcion")
    private  String descripcion;

    @Column(name = "materia")
    private String materia;



    @ManyToOne
    @JoinColumn(name = "profesor_id")
    private Profesor profesor;

    @OneToMany(mappedBy = "curso")
    private List<RegistroCurso> registroCursos = new ArrayList<>();


    private  int cantidadEstudiantes;
    public Curso() {
    }



    public Curso(Long id, String nombre, String descripcion, String materia, Profesor profesor, List<RegistroCurso> registroCursos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.materia = materia;
        this.profesor = profesor;
        this.registroCursos = registroCursos;
        this.cantidadEstudiantes=5;
    }


    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getMateria() {
        return materia;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public List<RegistroCurso> getRegistroCursos() {
        return registroCursos;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setRegistroCursos(List<RegistroCurso> registroCursos) {
        this.registroCursos = registroCursos;
    }

    public int getCantidadEstudiantes() {
        return cantidadEstudiantes;
    }

    public void setCantidadEstudiantes(int cantidadEstudiantes) {
        this.cantidadEstudiantes = cantidadEstudiantes;
    }
}
