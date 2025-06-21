package com.finsuma.ahorrarte.platform.userTransaction.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.finsuma.ahorrarte.platform.userTransaction.domain.model.valueobjects.TransactionAmount;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "value"))
    })
    private TransactionAmount amount;

    private LocalDateTime date;

    private String category;

    private String userId;

    // Constructor sin argumentos requerido por JPA
    public Transaction(Object o, String description, TransactionAmount amount, LocalDateTime date, String category, String userId) {}

    // Constructor completo para la creación de la entidad
    @JsonCreator
    public Transaction(
            @JsonProperty("description") String description,
            @JsonProperty("amount") TransactionAmount amount,
            @JsonProperty("date") LocalDateTime date,
            @JsonProperty("category") String category,
            @JsonProperty("userId") String userId
    ) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.category = category;
        this.userId = userId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TransactionAmount getAmount() {
        return amount;
    }

    public void setAmount(TransactionAmount amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
