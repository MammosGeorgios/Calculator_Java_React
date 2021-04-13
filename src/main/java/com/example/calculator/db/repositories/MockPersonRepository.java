package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.MockPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MockPersonRepository extends JpaRepository<MockPerson,Long> {

    List<MockPerson> getAllByAge(Long age);

}
