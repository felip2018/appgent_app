package com.fgarzon.appgent.models;

import java.io.Serializable;

public class Notification implements Serializable {
    private int case_id;
    private String type;
    private String description;
    private int from;
    private int to;
    private int readed;
    private String created_at;
    private String register_status;

    public Notification() {}

    public Notification(int case_id, String type, String description, int from, int to, int readed, String created_at, String register_status) {
        this.case_id = case_id;
        this.type = type;
        this.description = description;
        this.from = from;
        this.to = to;
        this.readed = readed;
        this.created_at = created_at;
        this.register_status = register_status;
    }

    public int getCaseId() {
        return case_id;
    }

    public void setCaseId(int case_id) {
        this.case_id = case_id;
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

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getReaded() {
        return readed;
    }

    public void setReaded(int readed) {
        this.readed = readed;
    }

    public String getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

    public String getRegisterStatus() {
        return register_status;
    }

    public void setRegisterStatus(String register_status) {
        this.register_status = register_status;
    }
}
