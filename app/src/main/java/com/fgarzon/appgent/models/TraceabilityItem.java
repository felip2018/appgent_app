package com.fgarzon.appgent.models;

public class TraceabilityItem {

    private int caseId;
    private String observations;

    public TraceabilityItem(int caseId, String observations) {
        this.caseId         = caseId;
        this.observations   = observations;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
