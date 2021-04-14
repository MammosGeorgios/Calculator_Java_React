package com.example.calculator.db.entity;

import javax.persistence.*;

@Entity
@Table(name="operation")
public class Operation {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="operationString",nullable=false)
    private String operationString;

    @Column(name="result",nullable=false)
    private String result;

    @ManyToOne
    @JoinColumn(name="userid",nullable=false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOperationString() {
        return operationString;
    }

    public void setOperationString(String operationString) {
        this.operationString = operationString;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
