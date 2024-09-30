package org.example.controller;

import org.example.dto.ActivityDTO;
import org.example.service.ActivityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/appActivitats")
@Validated
public class ActivityController {

    @Autowired
    private ActivityServiceImpl activityService;

    @PostMapping("/activity")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> registerActivity(@Valid @RequestBody ActivityDTO activityDTO) {
        return ResponseEntity.ok(activityService.createActivity(activityDTO));
    }

    @DeleteMapping("/activity/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Map<String, Object>> deleteActivity(@PathVariable String id) {
        return ResponseEntity.ok(activityService.deleteActivity(id));
    }

    @GetMapping("/activity")
    public ResponseEntity<Map<String, Object>> getActivities() {
        return ResponseEntity.ok(activityService.getActivities());
    }

    @PostMapping("/activity/{idActivity}/{idUser}")
    public ResponseEntity<Map<String, Object>> addUserToActivity(@PathVariable String idActivity, @PathVariable String idUser) {
        return ResponseEntity.ok(activityService.addUserToActivity(idActivity, idUser));
    }
}
