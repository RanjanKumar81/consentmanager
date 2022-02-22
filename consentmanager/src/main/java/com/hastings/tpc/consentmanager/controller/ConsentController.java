package com.hastings.tpc.consentmanager.controller;

import com.hastings.tpc.consentmanager.exception.ResourceNotFoundException;
import com.hastings.tpc.consentmanager.model.UserConsent;
import com.hastings.tpc.consentmanager.plugin.UserConsentPlugin;
import com.hastings.tpc.consentmanager.repository.UserConsentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/consent/v1")
public class ConsentController {

    @Autowired
    private UserConsentRepository consentRepo;
    @Autowired
    private UserConsentPlugin consentPlugin;

    @GetMapping("/document-consents/{userId}")
    public ResponseEntity<List<UserConsent>> getConsent(@PathVariable String userId) {
        List<UserConsent> consentList = consentRepo.findByUserId(userId);
        if (consentList.isEmpty()) {
            throw new ResourceNotFoundException(
                    "CST200005",
                    "Operation failed.",
                    "The document consent with the provided User Id does not exist."
            );
        }
        return ResponseEntity.ok(consentList);
    }

    @PostMapping("/document-consents")
    public ResponseEntity<UserConsent> insertDocumentConsent(@RequestBody UserConsent consent) {
        boolean isUpdate = false;
        if (!StringUtils.hasText(consent.getConsentId())) {
            String consentID = consentPlugin.generateConsentID();
            consent.setConsentId(consentID);
        } else {
            isUpdate = true;
            UserConsent entry = consentRepo.findById(consent.getConsentId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "CST200005",
                            "Operation failed.",
                            "The document consent with the provided User Id does not exist."
                    ));
            consent.setConsentId(consent.getConsentId());
        }
        if (!isUpdate && consent.getConsentReceivedDate() == null) {
            consent.setConsentReceivedDate(LocalDateTime.now(ZoneOffset.UTC));
        }
        consent.setLastModifiedDate(LocalDateTime.now(ZoneOffset.UTC));
        UserConsent c = consentRepo.save(consent);
        return ResponseEntity.ok(c);
    }
}
