package com.login.loginjwt.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "medicos")
public class Medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 50)
    private String nombre;

    @NotNull
    @Size(max = 50)
    private String apellido;

    @NotNull
    @Lob
    private String descripcion;

    public Medicos(){
        super();
    }

    public Medicos(Integer id, String nombre, String apellido, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
