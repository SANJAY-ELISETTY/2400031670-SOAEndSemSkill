package com.example.applicationapi.model;

public class ApplicationResponse {
    private Long id;
    private String applicantName;
    private String applicationType;
    private String status;

    public ApplicationResponse() {
    }

    public ApplicationResponse(Long id, String applicantName, String applicationType, String status) {
        this.id = id;
        this.applicantName = applicantName;
        this.applicationType = applicationType;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicationType() {
        return applicationType;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public void setApplicationType(String applicationType) {
        this.applicationType = applicationType;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
