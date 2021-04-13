package com.example.calculator.model;

import com.example.calculator.db.entity.MockTeam;

public class MockPersonDTO {

    private Long id;
    private String name;
    private Long age;
    private String mockTeamName;

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

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getMockTeamName() {
        return mockTeamName;
    }
    public void setMockTeamName(MockTeam mockTeam) {
        this.mockTeamName = mockTeam.getName();
    }

    public MockPersonDTO(){}
    public MockPersonDTO(String name, Long age) {
        this.name=name;
        this.age=age;
    }
    public MockPersonDTO(Long id, String name, Long age) {
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public MockPersonDTO(Long id, String name, Long age,String teamName) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.mockTeamName=teamName;
    }


}
