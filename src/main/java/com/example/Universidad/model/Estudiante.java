package com.example.Universidad.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "estudiante_id")
    private Long id;

    @Column(name = "nombre")
    private  String nombre;

    @Column(name = "apellido")
    private  String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;


    @OneToMany(mappedBy = "estudiante")
    private List<RegistroCurso> registroCursos = new ArrayList<>();




    public Estudiante() {
    }

    public Estudiante(Long id, String nombre, String apellido, LocalDate fechaNacimiento, List<RegistroCurso> registroCursos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.registroCursos = registroCursos;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public List<RegistroCurso> getRegistroCursos() {
        return registroCursos;
    }
}
