package com.example.calculator.db.entity;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="mockteam")
public class MockTeam {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable=true)
    private String name;

    @OneToMany(mappedBy = "id") // MUST BE THE PROPERTY OF THE LINKED CLASS!!!!
    private Set<MockPerson> mockPeople;

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

    public Set<MockPerson> getMockPeople() {
        return mockPeople;
    }

    public void setMockPeople(Set<MockPerson> mockPeople) {
        this.mockPeople = mockPeople;
    }
}
