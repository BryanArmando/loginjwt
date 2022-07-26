package com.login.loginjwt.domain;

import javax.persistence.*;

@Entity
@Table(name = "proveedores")
public class Proveedores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombreProveedor;

    private String numContactoProveedor;

    private String direccion;

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
