package com.finsuma.ahorrarte.platform.shared.infrastructure.persistence.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.net.URI;

@Configuration
public class DatabaseConfiguration {

    @Value("${DATABASE_URL:}")
    private String databaseUrl;

    @Bean
    @Primary
    @ConditionalOnProperty(name = "DATABASE_URL")
    public DataSource dataSource() {
        try {
            // Parse the DATABASE_URL from Render (format: postgresql://user:pass@host:port/db)
            URI dbUri = new URI(databaseUrl);
            
            String host = dbUri.getHost();
            int port = dbUri.getPort() != -1 ? dbUri.getPort() : 5432;
            String database = dbUri.getPath().substring(1); // Remove leading slash
            String[] userInfo = dbUri.getUserInfo().split(":");
            String username = userInfo[0];
            String password = userInfo[1];
            
            // Convert to JDBC URL format
            String jdbcUrl = String.format("jdbc:postgresql://%s:%d/%s", host, port, database);
            
            System.out.println("Configured database connection:");
            System.out.println("  JDBC URL: " + jdbcUrl);
            System.out.println("  Username: " + username);
            System.out.println("  Database: " + database);
            
            return DataSourceBuilder.create()
                    .url(jdbcUrl)
                    .username(username)
                    .password(password)
                    .driverClassName("org.postgresql.Driver")
                    .build();
        } catch (Exception e) {
            System.err.println("Failed to parse DATABASE_URL: " + databaseUrl);
            throw new RuntimeException("Failed to configure database from DATABASE_URL: " + databaseUrl, e);
        }
    }
}
