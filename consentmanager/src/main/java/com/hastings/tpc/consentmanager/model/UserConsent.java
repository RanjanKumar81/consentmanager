package com.hastings.tpc.consentmanager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "userconsent")
public class UserConsent implements Serializable {
    @Column(name = "consentId")
    private String consentId;
    @Column(name = "userId")
    private String userId;
    @Column(name = "documentId")
    private int documentId;
    @Column(name = "consentReceivedDate")
    private LocalDateTime consentReceivedDate;
    @Column(name = "consentValidTillDate")
    private LocalDateTime consentValidTillDate;
    @Column(name = "lastModifiedDate")
    private LocalDateTime lastModifiedDate;
    @Column(name = "revoked")
    private boolean revoked;

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    @Id
    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    public LocalDateTime getConsentReceivedDate() {
        return consentReceivedDate;
    }

    public void setConsentReceivedDate(LocalDateTime consentReceivedDate) {
        this.consentReceivedDate = consentReceivedDate;
    }

    public LocalDateTime getConsentValidTillDate() {
        return consentValidTillDate;
    }

    public void setConsentValidTillDate(LocalDateTime consentValidTillDate) {
        this.consentValidTillDate = consentValidTillDate;
    }

    @Override
    public String toString() {
        return "UserConsent{" +
                "consentId='" + consentId + '\'' +
                ", userId='" + userId + '\'' +
                ", documentId=" + documentId +
                ", consentReceivedDate=" + consentReceivedDate +
                ", consentValidTillDate=" + consentValidTillDate +
                '}';
    }
}
