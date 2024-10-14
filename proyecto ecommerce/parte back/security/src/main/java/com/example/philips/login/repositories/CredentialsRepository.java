package com.example.philips.login.repositories;

import com.example.philips.login.entities.CredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CredentialsRepository extends JpaRepository<CredentialsEntity, UUID> {
    CredentialsEntity findByUsername(String username);
}
