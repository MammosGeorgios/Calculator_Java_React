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

    @OneToMany(mappedBy = "user")
    private Set<User> users;

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
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
