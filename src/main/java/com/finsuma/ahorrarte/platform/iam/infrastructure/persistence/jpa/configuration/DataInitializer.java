package com.finsuma.ahorrarte.platform.iam.infrastructure.persistence.jpa.configuration;

import com.finsuma.ahorrarte.platform.iam.domain.model.entities.Role;
import com.finsuma.ahorrarte.platform.iam.domain.model.valueobjects.Roles;
import com.finsuma.ahorrarte.platform.iam.infrastructure.persistence.jpa.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        // Initialize roles if they don't exist
        if (roleRepository.count() == 0) {
            System.out.println("Initializing default roles...");
              Arrays.stream(Roles.values()).forEach(roleName -> {
                if (roleRepository.findByName(roleName).isEmpty()) {
                    Role role = new Role(roleName);
                    roleRepository.save(role);
                    System.out.println("Created role: " + roleName);
                }
            });
            
            System.out.println("Role initialization completed.");
        } else {
            System.out.println("Roles already exist, skipping initialization.");
        }
    }
}
