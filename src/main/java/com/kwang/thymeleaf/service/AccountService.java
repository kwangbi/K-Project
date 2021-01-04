package com.kwang.thymeleaf.service;

import com.kwang.thymeleaf.model.Role;
import com.kwang.thymeleaf.model.User;
import com.kwang.thymeleaf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user){

        // password 암호화
        String ePass = passwordEncoder.encode(user.getPassword());
        user.setPassword(ePass);
        user.setEnabled(true);

        // role 저장
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }
}
