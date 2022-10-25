package com.fgarzon.appgent.models;

public class Case {
    private int caseId;
    private String description;
    private String caseStatus;
    private String createdAt;

    public Case(int caseId, String description, String caseStatus, String createdAt) {
        this.caseId = caseId;
        this.description = description;
        this.caseStatus = caseStatus;
        this.createdAt = createdAt;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(String caseStatus) {
        this.caseStatus = caseStatus;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
