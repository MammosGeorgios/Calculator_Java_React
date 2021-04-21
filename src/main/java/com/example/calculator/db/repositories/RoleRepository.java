package com.example.calculator.db.repositories;

import com.example.calculator.db.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role getRoleById(Long id);
    Role findByRoleName(String roleName);
}
