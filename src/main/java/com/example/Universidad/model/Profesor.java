package com.example.Universidad.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "profesor")
@JsonIdentityInfo(scope = Profesor.class, generator= ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
    @JsonIgnore
    private Long id;

    @Column(name = "nombre")
    private  String nombre;

    @Column(name = "apellido")
    private  String apellido;

    @Column(name = "fecha_inicio_trabajo")
    private LocalDate fechaInicioTrabajo;

//    @ElementCollection
//    @CollectionTable(name = "titulos_academicos", joinColumns = @JoinColumn(name = "profesor_id"))
//    @Column(name = "titulo")
//    private List<String> tulosAcademicos = new ArrayList<>();
    @Column(name = "titulos")
    private String tulosAcademicos;

    @OneToMany(mappedBy = "profesor",cascade = CascadeType.ALL)
    private  List<Curso> cursos= new ArrayList<>();


    public Profesor() {
    }

    public Profesor(Long id, String nombre, String apellido, LocalDate fechaInicioTrabajo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public LocalDate getFechaInicioTrabajo() {
        return fechaInicioTrabajo;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaInicioTrabajo(LocalDate fechaInicioTrabajo) {
        this.fechaInicioTrabajo = fechaInicioTrabajo;
    }


    public String getTulosAcademicos() {
        return tulosAcademicos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
