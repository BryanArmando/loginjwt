package com.login.loginjwt.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Productos {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "el campo no puede estar vacio")
    @Size(max = 100)
    private String nombreGenerico;


    @Size(max = 100)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String nombreComercial;


    @Size(max = 250)
    @NotEmpty(message = "el campo no puede estar vacio")
    private String descripcion;

    @Positive(message = "No puede ingresar valores negativos")
    @Digits(message = "Solo puede ingresar numeros", integer = 3, fraction = 2)
    private Double pvpVenta;

    @Positive(message = "No puede ingresar valores negativos")
    @Digits(message = "Solo puede ingresar numeros", integer = 3, fraction = 2)
    private Double pvpCompra;

    @PositiveOrZero(message = "No puede ingresar valores negativos")
    private Integer cantidad;

    @Future
    @NotEmpty(message = "el campo no puede estar vacío")
    private Date caducidad;

    @NotEmpty(message = "El campo no debe estar vacio")
    private String registroSanitario;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sucursal_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sucursales sucursal;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tipo_id", nullable = false)
    @JsonIgnore
    private TipoProducto tipoProducto;

    @ManyToOne
    @JoinColumn(name = "ubicacion_id", nullable = false)
    @JsonIgnore
    private UbicacionProducto ubicacionProducto;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreGenerico() {
        return nombreGenerico;
    }

    public void setNombreGenerico(String nombreGenerico) {
        this.nombreGenerico = nombreGenerico;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPvpVenta() {
        return pvpVenta;
    }

    public void setPvpVenta(Double pvpVenta) {
        this.pvpVenta = pvpVenta;
    }

    public Double getPvpCompra() {
        return pvpCompra;
    }

    public void setPvpCompra(Double pvpCompra) {
        this.pvpCompra = pvpCompra;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Sucursales getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursales sucursal) {
        this.sucursal = sucursal;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public UbicacionProducto getUbicacionProducto() {
        return ubicacionProducto;
    }

    public void setUbicacionProducto(UbicacionProducto ubicacionProducto) {
        this.ubicacionProducto = ubicacionProducto;
    }

    public Date getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(Date caducidad) {
        this.caducidad = caducidad;
    }

    public String getRegistroSanitario() {
        return registroSanitario;
    }

    public void setRegistroSanitario(String registroSanitario) {
        this.registroSanitario = registroSanitario;
    }

    public Productos(Integer id, String nombreGenerico, String nombreComercial, String descripcion, Double pvpVenta, Double pvpCompra, Integer cantidad, Date caducidad, String registroSanitario, Sucursales sucursal, TipoProducto tipoProducto, UbicacionProducto ubicacionProducto) {
        this.id = id;
        this.nombreGenerico = nombreGenerico;
        this.nombreComercial = nombreComercial;
        this.descripcion = descripcion;
        this.pvpVenta = pvpVenta;
        this.pvpCompra = pvpCompra;
        this.cantidad = cantidad;
        this.caducidad = caducidad;
        this.registroSanitario = registroSanitario;
        this.sucursal = sucursal;
        this.tipoProducto = tipoProducto;
        this.ubicacionProducto = ubicacionProducto;
    }

    public Productos() {
    }

    public Productos(Integer id, String descripcion, String nombreGenerico, String nombreComercial, Double pvpVenta) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombreGenerico = nombreGenerico;
        this.nombreComercial = nombreComercial;
        this.pvpVenta = pvpVenta;
    }
}
