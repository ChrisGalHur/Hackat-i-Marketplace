package org.example.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.UserDTO;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class AdminsInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void run(String... args) throws Exception {
        File file = new File("src/main/resources/admins.json");

        try {
            UserDTO[] admins = objectMapper.readValue(file, UserDTO[].class);

            // Verify if the admins already exist in the database
            for (UserDTO admin : admins) {
                if (userRepository.findByEmail(admin.getEmail()).isEmpty()) {
                    admin.setPassword(passwordEncoder.encode(admin.getPassword()));

                    User adminEntity = new User();
                    adminEntity.setName(admin.getName());
                    adminEntity.setSecondName(admin.getSecondName());
                    adminEntity.setEmail(admin.getEmail());
                    adminEntity.setPassword(admin.getPassword());
                    adminEntity.setRole("ADMIN");

                    userRepository.save(adminEntity);
                    log.info("Admin {} created successfully", admin.getEmail());
                } else {
                    log.info("Admin {} already exists in the database", admin.getEmail());
                }
                }
        } catch (IOException e) {
            log.error("Error reading the admins file: {}", e.getMessage());
        }
    }
}
