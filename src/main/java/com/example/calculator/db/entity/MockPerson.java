package com.example.calculator.db.entity;

import javax.persistence.*;

@Entity
@Table(name="mockpeople")
public class MockPerson {
    @Id
    @Column(name="ID",nullable=false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=false)
    private String name;

    @Column(name="Age",nullable=false)
    private Long age;

    @ManyToOne
    @JoinColumn(name="teamid",nullable = false)
    private MockTeam mockTeam;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public MockPerson(){}

    public MockPerson(String name, Long age){
        this.name=name;
        this.age=age;
    }

    public MockPerson(Long id, String name, Long age){
        this.id=id;
        this.name=name;
        this.age=age;
    }

    public MockTeam getMockTeam() {
        return mockTeam;
    }

    public void setMockTeam(MockTeam mockTeam) {
        this.mockTeam = mockTeam;
    }


}
