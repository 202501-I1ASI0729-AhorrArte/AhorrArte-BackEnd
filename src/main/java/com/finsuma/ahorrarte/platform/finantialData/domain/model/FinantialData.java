package com.finsuma.ahorrarte.platform.finantialData.domain.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "DATOS_FINANCIEROS")
public class FinantialData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DATO_FINANCIERO")
    private Long idDatoFinanciero;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    @Column(name = "TIPO_DATO", columnDefinition = "TEXT")
    private String tipoDato;

    @Column(name = "MONTO", precision = 10, scale = 2)
    private BigDecimal monto;

    @Column(name = "FECHA")
    private LocalDate fecha;

    @Column(name = "DESCRIPCION", columnDefinition = "TEXT")
    private String descripcion;

    // Getters y Setters

    public Long getIdDatoFinanciero() {
        return idDatoFinanciero;
    }

    public void setIdDatoFinanciero(Long idDatoFinanciero) {
        this.idDatoFinanciero = idDatoFinanciero;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
