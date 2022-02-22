package com.hastings.tpc.consentmanager.repository;

import com.hastings.tpc.consentmanager.model.UserConsent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserConsentRepository extends JpaRepository<UserConsent, String> {
    public List<UserConsent> findByUserId(String userId);
}
