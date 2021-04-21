package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.Operation;
import com.example.calculator.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {

    List<Operation> getAllByUser(User user);
}
