package com.example.calculator.db.entity;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal result;

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

    public BigDecimal getResult() {
        return result;
    }

    public void setResult(BigDecimal result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
