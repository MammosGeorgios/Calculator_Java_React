package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByName(String name);
    User getById(Long id);

}