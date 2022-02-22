package com.hastings.tpc.consentmanager.plugin;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserConsentPlugin {

    public String generateConsentID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
