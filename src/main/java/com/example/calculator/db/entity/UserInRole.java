package com.example.calculator.db.entity;

import javax.persistence.*;

@Entity
@Table(name="userinrole")
public class UserInRole {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="userid",nullable=false)
    private User user;

    @ManyToOne
    @JoinColumn(name="roleid",nullable=false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
