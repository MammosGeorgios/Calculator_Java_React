package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.Role;
import com.example.calculator.db.entity.User;
import com.example.calculator.db.entity.UserInRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInRoleRepository extends JpaRepository<UserInRole, Long> {
    List<UserInRole> findAllByUserId (Long id);
    //List<Role> findAllByUserId(Long id);


}
