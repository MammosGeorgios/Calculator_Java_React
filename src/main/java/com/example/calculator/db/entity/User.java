package com.example.calculator.db.entity;



import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="username",nullable=false)
    private String username;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="role",nullable=false)
    private String role;

    @OneToMany(mappedBy = "user")
    private Set<Operation> operations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }



}
