package com.finsuma.ahorrarte.platform.userContext.domain.model.entities;

import com.finsuma.ahorrarte.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ConsultaAsesoria extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TIPO_CONSULTA", nullable = false)
    private String tipoConsulta;

    @Column(name = "FECHA_CONSULTA", nullable = false)
    private LocalDate fechaConsulta;

    @Column(name = "RESULTADO")
    private String resultado;

    // Getters y Setters
    public String getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    public LocalDate getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(LocalDate fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
