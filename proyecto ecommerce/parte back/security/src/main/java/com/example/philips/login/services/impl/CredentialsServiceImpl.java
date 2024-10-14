package com.example.philips.login.services.impl;

import com.example.philips.login.entities.CredentialsEntity;
import com.example.philips.login.mappers.CredentialsMapper;
import com.example.philips.login.models.CredentialsDTO;
import com.example.philips.login.repositories.CredentialsRepository;
import com.example.philips.login.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public CredentialsEntity save(CredentialsDTO credentialsDTO) {
        CredentialsEntity credentialsEntity = new CredentialsEntity(credentialsDTO.username(), passwordEncoder.encode(credentialsDTO.password()),credentialsDTO.role());
        return credentialsRepository.save(credentialsEntity);
    }

    @Override
    public CredentialsEntity getById(UUID id) {
        return credentialsRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<CredentialsEntity> getAll() {
        return credentialsRepository.findAll();
    }

    @Override
    public CredentialsEntity uploadById(UUID id, CredentialsDTO credentialsDTO) {
        CredentialsEntity credentialsEntity = credentialsRepository.findById(id).orElseThrow(RuntimeException::new);
        credentialsEntity.setUsername(credentialsEntity.getUsername());
        credentialsEntity.setPassword(credentialsEntity.getPassword());
        credentialsEntity.setRole(credentialsEntity.getRole());
        return credentialsRepository.save(credentialsEntity);
    }

    @Override
    public CredentialsEntity getByUsername(String username) {
        return credentialsRepository.findByUsername(username);
    }

    @Override
    public void deleteById(UUID id) {
            credentialsRepository.deleteById(id);
    }
}
