package org.example.repository;

import org.example.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {

    Optional<Activity> findByName(String activityName);
}
