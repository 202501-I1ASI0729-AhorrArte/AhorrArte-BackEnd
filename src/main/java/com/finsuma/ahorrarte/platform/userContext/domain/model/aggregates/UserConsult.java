package com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates;

import com.finsuma.ahorrarte.platform.userContext.domain.model.entities.ConsultaAsesoria;
import jakarta.persistence.*;

@Entity
@Table(name = "user_consult")
public class UserConsult {

    @EmbeddedId
    private UserConsultId id;

    @ManyToOne
    @JoinColumn(name = "ID_CONSULTA", insertable = false, updatable = false, nullable = false)
    private ConsultaAsesoria consultaAsesoria;

    // Getters y Setters

    public UserConsultId getId() {
        return id;
    }

    public void setId(UserConsultId id) {
        this.id = id;
    }

    public ConsultaAsesoria getConsultaAsesoria() {
        return consultaAsesoria;
    }

    public void setConsultaAsesoria(ConsultaAsesoria consultaAsesoria) {
        this.consultaAsesoria = consultaAsesoria;
    }

    // Equals y HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserConsult that = (UserConsult) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
