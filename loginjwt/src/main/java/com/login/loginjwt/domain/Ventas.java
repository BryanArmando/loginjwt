package com.login.loginjwt.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@DateTimeFormat
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private java.sql.Date fecha_venta;


    private Time hora_venta;

    @NotEmpty
    private String medicamento;

    @NotNull
    private Integer cantidad;

    @NotEmpty
    private Double pvp_venta;

    @NotEmpty
    private Double total_venta;

    @NotEmpty
    private Double pvp_compra;

    @NotEmpty
    private Double total_compra;

    @NotEmpty
    private String registro_sanitario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sucursal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sucursales sucursal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public java.sql.Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(java.sql.Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Time getHora_venta() {
        return hora_venta;
    }

    public void setHora_venta(Time hora_venta) {
        this.hora_venta = hora_venta;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPvp_venta() {
        return pvp_venta;
    }

    public void setPvp_venta(Double pvp_venta) {
        this.pvp_venta = pvp_venta;
    }

    public Double getPvp_compra() {
        return pvp_compra;
    }

    public void setPvp_compra(Double pvp_compra) {
        this.pvp_compra = pvp_compra;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public Double getTotal_compra() {
        return total_compra;
    }

    public void setTotal_compra(Double total_compra) {
        this.total_compra = total_compra;
    }

    public String getRegistro_sanitario() {
        return registro_sanitario;
    }

    public void setRegistro_sanitario(String registro_sanitario) {
        this.registro_sanitario = registro_sanitario;
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }

    public Ventas() {
    }

    public Ventas(Integer id, java.sql.Date fecha_venta, Time hora_venta, String medicamento, Integer cantidad, Double pvp_venta, Double total_venta, Double pvp_compra, Double total_compra, String registro_sanitario, Sucursales sucursal) {
        this.id = id;
        this.fecha_venta = fecha_venta;
        this.hora_venta = hora_venta;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.pvp_venta = pvp_venta;
        this.total_venta = total_venta;
        this.pvp_compra = pvp_compra;
        this.total_compra= total_compra;
        this.registro_sanitario = registro_sanitario;
        this.sucursal = sucursal;
    }
}
