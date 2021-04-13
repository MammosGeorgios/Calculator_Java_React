package com.example.calculator.model;

public class MockPersonDTO {

    private Long id;
    private String name;
    private Long age;

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


}
