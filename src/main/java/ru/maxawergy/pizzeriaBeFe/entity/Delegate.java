package ru.maxawergy.pizzeriaBeFe.entity;

import javax.persistence.*;

@Entity
@Table(name = "delegate")
public class Delegate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long delId;
    private String fullName;
    private String phoneNumber;
    private String email;



    public Delegate() {

    }

    public Delegate(String fullName, String phoneNumber, String email) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Long getDelId() {
        return delId;
    }

    public void setDelId(Long delId) {
        this.delId = delId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
