package com.example.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotEmpty(message = "name empty")
    @Size(min = 2, max = 30, message = "name size [2-30]")
    @Pattern(regexp = "[A-Za-z]+", message = "only A-Z , a-z")
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private Integer password;
    @NotEmpty(message = "lastname empty")
    @Size(min = 2, max = 30, message = "lastname size [2-30]")
    @Pattern(regexp = "[A-Za-z]+", message = "only A-Z , a-z")
    @Column(name = "lastName")
    private String lastName;

    public User() {
    }

    public User(String name, String lastName, Integer password) {
        this.name = name;
        this.lastName = lastName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
