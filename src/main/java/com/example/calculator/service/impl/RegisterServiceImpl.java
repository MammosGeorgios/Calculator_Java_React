package com.example.calculator.service.impl;

import com.example.calculator.db.entity.Role;
import com.example.calculator.db.entity.User;
import com.example.calculator.db.entity.UserInRole;
import com.example.calculator.db.repositories.RoleRepository;
import com.example.calculator.db.repositories.UserInRoleRepository;
import com.example.calculator.db.repositories.UserRepository;
import com.example.calculator.model.UserDTO;
import com.example.calculator.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserInRoleRepository userInRoleRepository;

    @Override
    public void newUser(UserDTO userDTO) {

        // Create the new entities of user and UserInRoles
        User user = newUserFromDTO(userDTO);
        UserInRole userInRole = new UserInRole();
        Role role = roleRepository.getRoleById(2L); // 2L because we always want the second role for new users

        // Save the entity objects
        userRepository.save(user);

        userInRole.setUser(user);
        userInRole.setRole(role);
        userInRoleRepository.save(userInRole);
    }

    private static User newUserFromDTO(UserDTO userDTO){
        User user = new User();

        user.setUsername(userDTO.getUsername());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userDTO.getPassword());
        user.setPassword(encodedPassword);

        user.setName(userDTO.getName());

        return user;

    }
}
