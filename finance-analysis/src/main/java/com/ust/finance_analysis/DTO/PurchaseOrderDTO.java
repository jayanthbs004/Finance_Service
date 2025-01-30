package com.ust.finance_analysis.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderDTO {
    @JsonProperty("id") 
    private String poId;
    private String clientName;
    private double budget;
    private int duration;
    private String termsOfPayment; // 'monthly', 'upfront'
    private String poCreationDate;
    private String personOfContact;
    public PurchaseOrderDTO() {
    }
    public PurchaseOrderDTO( String poId, String clientName, double budget, int duration,
            String termsOfPayment, String poCreationDate, String personOfContact) {

        this.poId = poId;
        this.clientName = clientName;
        this.budget = budget;
        this.duration = duration;
        this.termsOfPayment = termsOfPayment;
        this.poCreationDate = poCreationDate;
        this.personOfContact = personOfContact;
    }

    public String getPoId() {
        return poId;
    }
    public void setPoId(String poId) {
        this.poId = poId;
    }
    public String getClientName() {
        return clientName;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public String getTermsOfPayment() {
        return termsOfPayment;
    }
    public void setTermsOfPayment(String termsOfPayment) {
        this.termsOfPayment = termsOfPayment;
    }
    public String getPoCreationDate() {
        return poCreationDate;
    }
    public void setPoCreationDate(String poCreationDate) {
        this.poCreationDate = poCreationDate;
    }
    public String getPersonOfContact() {
        return personOfContact;
    }
    public void setPersonOfContact(String personOfContact) {
        this.personOfContact = personOfContact;
    }
    
}
