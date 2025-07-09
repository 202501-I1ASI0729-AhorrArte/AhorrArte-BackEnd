package com.FinSuma.AhorrArte.platform.iam.domain.model.entities;

import com.FinSuma.AhorrArte.platform.iam.domain.model.valueobjects.Roles;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Roles name;

    public Role(Roles name) { this.name = name; }

    // Devolver el nombre rol
    public String getStringName() { return name.name(); }

    // Método requerido por el UserCommandServiceImpl
    public Roles getName() { return name; }

    // Getter para compatibilidad
    public Long getId() { return id; }

    // Devolver cómo defecto el role USER
    public static Role getDefaultRole() {return new Role(Roles.ROLE_USER); }

    // Crear un nuevo role
    public static Role toRoleFromName(String name) { return new Role(Roles.valueOf(name)); }

    // Validad roles
    public static List<Role> validateRoleSet(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            return List.of(getDefaultRole());
        }
        return roles;
    }
}

