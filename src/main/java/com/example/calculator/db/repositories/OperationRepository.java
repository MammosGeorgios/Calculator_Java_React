package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,Long> {

}
