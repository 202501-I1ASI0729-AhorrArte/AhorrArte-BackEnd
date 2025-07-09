package com.FinSuma.AhorrArte.platform.finantialEducation.domain.model.entities;


import com.FinSuma.AhorrArte.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Preguntas extends AuditableModel {
    private String texto;
    private Long id;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuestas> respuestas;

    public Preguntas() {}
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}

