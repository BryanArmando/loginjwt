package com.login.loginjwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pedidos")
public class Pedidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 250)
    @NotEmpty(message = "no puede estar vacío")
    private String productoPedido;

    @PositiveOrZero(message = "No puede ingresar valores negativos")
    @NotEmpty(message = "Debe ingresar un valor")
    private Integer cantidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "proveedor_id", nullable = false)
    @JsonIgnore
    private Proveedores proveedores;

    public Pedidos(Integer id, String productoPedido, Integer cantidad, Proveedores proveedores) {
        this.id = id;
        this.productoPedido = productoPedido;
        this.cantidad = cantidad;
        this.proveedores = proveedores;
    }
    public Pedidos(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductoPedido() {
        return productoPedido;
    }

    public void setProductoPedido(String productoPedido) {
        this.productoPedido = productoPedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }
}
