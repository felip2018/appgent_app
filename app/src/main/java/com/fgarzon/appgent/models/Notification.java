package com.fgarzon.appgent.models;

public class Notification {
    private int caseId;
    private String type;
    private String description;
    private int readed;
    private String createdAt;

    public Notification(int caseId, String type, String description, int readed, String createdAt) {
        this.caseId = caseId;
        this.type = type;
        this.description = description;
        this.readed = readed;
        this.createdAt = createdAt;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
