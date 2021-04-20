package com.example.calculator.db.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="rolename",nullable=false)
    private String roleName;

    @OneToMany(mappedBy="role")
    private Set<UserInRole> userInRoles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserInRole> getUserInRoles() {
        return userInRoles;
    }

    public void setUserInRoles(Set<UserInRole> userInRoles) {
        this.userInRoles = userInRoles;
    }
}
