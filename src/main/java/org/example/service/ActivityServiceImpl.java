package org.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.ActivityDTO;
import org.example.exception.ActivityFullException;
import org.example.exception.ActivityNotFoundException;
import org.example.exception.UserNotFoundException;
import org.example.model.Activity;
import org.example.repository.ActivityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ActivityServiceImpl implements IActivityService {

    //region PROPERTIES
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ModelMapper modelMapper;
    //endregion PROPERTIES

    //region METHODS
    @Override
    public Map<String,Object> createActivity(final ActivityDTO activityDTO) {
        try {
            Activity activity = modelMapper.map(activityDTO, Activity.class);
            activity.setParticipants(new ArrayList<>());
            activity = activityRepository.save(activity);

            return createResponse("Activity created successfully", activity);
        }catch (Exception e) {
            log.error("Error creating activity: {}", e.getMessage(), e);
            throw new RuntimeException("Error creating activity: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> deleteActivity(final String id) {
        try {
            Activity activity = activityRepository.findById(id)
                    .orElseThrow(() -> new ActivityNotFoundException("Activity not found"));
            activityRepository.delete(activity);

            return createResponse("Activity deleted successfully", activity);
        }catch (ActivityNotFoundException e){
            log.error("Error deleting activity: {}", e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error("Error deleting activity: {}", e.getMessage(), e);
            throw new RuntimeException("Error deleting activity: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> getActivities() {
        try {
            if(activityRepository.count() == 0) {
                throw new ActivityNotFoundException("No activities found");
            }

            // Get all activities and return on DTO format
            List<ActivityDTO> activities = activityRepository.findAll().stream()
                    .map(activity -> modelMapper.map(activity, ActivityDTO.class))
                    .toList();

            return Map.of("activities", activities);
        }catch (Exception e) {
            log.error("Error getting activities: {}", e.getMessage(), e);
            throw new RuntimeException("Error getting activities: " + e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> addUserToActivity(String activityId, String userId) {
        try {
            Activity activity = activityRepository.findById(activityId)
                    .orElseThrow(() -> new ActivityNotFoundException("Activity not found"));

            // Check if the user is registered in database
            if(!userService.existsById(userId)) {
                throw new UserNotFoundException("User not found");
            }

            if(!activity.haveCapacity()) {
                throw new ActivityFullException("Activity is Already Full");
            }

            if(activity.getParticipants().contains(userId)) {
                throw new ActivityFullException("User is already in the activity");
            }

            activity.getParticipants().add(userId);
            activity = activityRepository.save(activity);

            return createResponse("User added to activity successfully", activity);
        }catch (ActivityNotFoundException | ActivityFullException e) {
            log.error("Error adding user to activity: {}", e.getMessage(), e);
            throw e;
        }catch (Exception e) {
            log.error("Error adding user to activity: {}", e.getMessage(), e);
            throw new RuntimeException("Error adding user to activity: " + e.getMessage(), e);
        }
    }

    @Override
    public ResponseEntity<byte[]> exportActivitiesAsJson() {
        try {
            List<ActivityDTO> activities = activityRepository.findAll().stream()
                    .map(activity -> modelMapper.map(activity, ActivityDTO.class))
                    .toList();

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(activities);

            byte[] jsonBytes = jsonString.getBytes(StandardCharsets.UTF_8);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.attachment().filename("activities.json").build());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(jsonBytes);
        } catch (Exception e) {
            log.error("Error exporting activities as JSON: {}", e.getMessage(), e);
            throw new RuntimeException("Error exporting activities as JSON: " + e.getMessage(), e);
        }
    }
    //endregion METHODS

    //region EXTRA METHODS
    private Map<String, Object> createResponse(String message, Activity activity) {
        Map<String, Object> response = new HashMap<>();
        int participants = activity.getParticipants().size();
        ActivityDTO activityDTO = modelMapper.map(activity, ActivityDTO.class);

        response.put("message", message);
        response.put("activity", Map.of(
                "activity_name", activityDTO.getName(),
                "description", activityDTO.getDescription(),
                "capacity", activityDTO.getCapacity(),
                "participants", participants
        ));
        return response;
    }
    //endregion EXTRA METHODS
}
