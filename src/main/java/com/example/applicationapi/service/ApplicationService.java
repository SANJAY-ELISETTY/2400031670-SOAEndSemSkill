package com.example.applicationapi.service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.applicationapi.model.ApplicationResponse;

@Service
public class ApplicationService {
    private final Map<Long, ApplicationResponse> applications = Map.of(
        101L, new ApplicationResponse(101L, "Sanjay", "Student", "APPROVED"),
        102L, new ApplicationResponse(102L, "Rahul", "Scholarship", "PENDING"),
        103L, new ApplicationResponse(103L, "Priya", "Internship", "REJECTED")
    );

    public Optional<ApplicationResponse> getApplicationById(Long id) {
        return Optional.ofNullable(applications.get(id));
    }
}
