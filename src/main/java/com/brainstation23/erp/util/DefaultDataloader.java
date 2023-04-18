package com.brainstation23.erp.util;

import com.brainstation23.erp.constant.UserRole;
import com.brainstation23.erp.persistence.entity.UserEntity;
import com.brainstation23.erp.persistence.repository.UserRepository;
import com.brainstation23.erp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultDataloader implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        var entity = new UserEntity();
        entity.setId(UUID.randomUUID())
                .setFirstName("Tonmoy")
                .setLastName("Saha")
                .setEmail("admin@gmail.com")
                .setPassword("toughpass")
                .setSalary(10000.00)
                .setRole(UserRole.ADMIN);
        userRepository.save(entity);
    }
}
