package com.login.loginjwt.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 100)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String nombreProveedor;

    @Size(max = 12)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String numContactoProveedor;

    @Size(max = 150)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String direccion;

    @Size(max = 30)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String ruc;

    public Proveedores(Integer id, String nombreProveedor, String numContactoProveedor, String direccion, String ruc) {
        this.id = id;
        this.nombreProveedor = nombreProveedor;
        this.numContactoProveedor = numContactoProveedor;
        this.direccion = direccion;
        this.ruc = ruc;
    }

    public Proveedores() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getNumContactoProveedor() {
        return numContactoProveedor;
    }

    public void setNumContactoProveedor(String numContactoProveedor) {
        this.numContactoProveedor = numContactoProveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }


}
