package com.FinSuma.AhorrArte.platform.finantialData.interfaces.rest.resources;

import java.math.BigDecimal;
import java.time.LocalDate;

public class FinantialDataResource {

    private Long idDatoFinanciero;
    private Long idUsuario;
    private String tipoDato;
    private BigDecimal monto;
    private LocalDate fecha;
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

