package com.qa.bae.account;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Accounts")
public class Account {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int accountNumber;

    protected Account() {

    }

    public Account(String firstName, String lastName, String emailAddress, int accountNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountNumber = accountNumber;
        this.emailAddress = emailAddress;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
    public String getId() {
        return this.id;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
}
