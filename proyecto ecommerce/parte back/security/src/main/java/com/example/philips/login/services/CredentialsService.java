package com.example.philips.login.services;

import com.example.philips.login.entities.CredentialsEntity;
import com.example.philips.login.models.CredentialsDTO;

import java.util.List;
import java.util.UUID;

public interface CredentialsService {
    CredentialsEntity save(CredentialsDTO credentialsDTO);
    CredentialsEntity getById(UUID id);
    List<CredentialsEntity> getAll();
    CredentialsEntity uploadById(UUID id, CredentialsDTO credentialsDTO);
    CredentialsEntity getByUsername(String username);
    void deleteById(UUID id);
}
