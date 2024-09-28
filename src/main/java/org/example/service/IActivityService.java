package org.example.service;

import org.example.dto.ActivityDTO;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IActivityService {

    Map<String,Object> createActivity(ActivityDTO activityDTO);

    Map<String, Object> deleteActivity(String id);

    Map<String, Object> getActivities();

    Map<String, Object> addUserToActivity(String activityId, String userId);

    ResponseEntity<byte[]> exportActivitiesAsJson();
}
