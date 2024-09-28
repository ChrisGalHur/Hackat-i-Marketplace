package org.example.Utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.ActivityDTO;
import org.example.dto.UserDTO;
import org.example.model.Activity;
import org.example.model.User;
import org.example.repository.ActivityRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class Initializer implements CommandLineRunner {

    //region PROPERTIES
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;
    //endregion PROPERTIES

    @Override
    public void run(String... args) throws Exception {
        loadAdmins();
        loadActivities();
    }

    //region PRIVATE METHODS
    private void loadAdmins() {
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
                    adminEntity.setAge(admin.getAge());
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

    private void loadActivities() {
        File file = new File("src/main/resources/activities.json");

        try {
            Activity[] activities = objectMapper.readValue(file, Activity[].class);

            // Verify if the activities already exist in the database
            for (Activity activity : activities) {
                if (activityRepository.findByName(activity.getName()).isEmpty()) {
                    Activity activityEntity = getActivityEntity(activity);
                    activityRepository.save(activityEntity);

                    log.info("Activity {} created successfully", activity.getName());
                } else {
                    log.info("Activity {} already exists in the database", activity.getName());
                }
            }
        } catch (IOException e) {
            log.error("Error reading the activities file: {}", e.getMessage());
        }
    }

    private static Activity getActivityEntity(Activity activity) {
        Activity activityEntity = new Activity();
        activityEntity.setName(activity.getName());
        activityEntity.setDescription(activity.getDescription());
        activityEntity.setCapacity(activity.getCapacity());
        if(activity.getParticipants() != null) {
            activityEntity.setParticipants(activity.getParticipants());
        } else {
            activityEntity.setParticipants(new ArrayList<>());
        }
        return activityEntity;
    }
    //endregion PRIVATE METHODS
}
