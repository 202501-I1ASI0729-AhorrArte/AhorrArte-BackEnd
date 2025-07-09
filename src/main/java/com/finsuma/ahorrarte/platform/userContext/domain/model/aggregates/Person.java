package com.finsuma.ahorrarte.platform.userContext.domain.model.aggregates;

import com.finsuma.ahorrarte.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.finsuma.ahorrarte.platform.userContext.domain.model.commands.CreatePersonCommand;
import com.finsuma.ahorrarte.platform.userContext.domain.model.valueobjects.EmailAddress;
import com.finsuma.ahorrarte.platform.userContext.domain.model.valueobjects.PersonName;
import com.finsuma.ahorrarte.platform.userContext.domain.model.valueobjects.StreetAddress;
import jakarta.persistence.*;

@Entity
public class Person extends AuditableAbstractAggregateRoot<Person> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonName getName() {
        return name;
    }

    public void setName(PersonName name) {
        this.name = name;
    }

    public EmailAddress getEmail() {
        return email;
    }

    public void setEmail(EmailAddress email) {
        this.email = email;
    }

    public StreetAddress getAddress() {
        return address;
    }

    public void setAddress(StreetAddress address) {
        this.address = address;
    }

    @Embedded
    private PersonName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "email_address"))})
    private EmailAddress email;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number"))})
    private StreetAddress address;

    public Person(String firstName, String lastName, String email, String street, String number) {
        this.name = new PersonName(firstName, lastName);
        this.email = new EmailAddress(email);
        this.address = new StreetAddress(street, number);
    }

    public Person() {}

    public Person(CreatePersonCommand command) {
        this.name = new PersonName(command.firstName(), command.lastName());
        this.email = new EmailAddress(command.email());
        this.address = new StreetAddress(command.street(), command.number());
    }

    public void updateName(String firstName, String lastName) {
        this.name = new PersonName(firstName, lastName);
    }

    public void updateEmail(String email) {
        this.email = new EmailAddress(email);
    }

    public void updateAddress(String street, String number) {
        this.address = new StreetAddress(street, number);
    }

    public String getFullName() {return name.getFullName();}

    public String getEmailAddress() {
        return email.address();
    }

    public String getStreetAddress() {
        return address.getStreetAddress();
    }



}
