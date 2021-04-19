package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.Operation;
import com.example.calculator.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation,Long> {

    List<Operation> getAllByUser(User user);
}
