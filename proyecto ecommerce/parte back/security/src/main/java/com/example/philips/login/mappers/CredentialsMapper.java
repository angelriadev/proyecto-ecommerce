package com.example.philips.login.mappers;

import com.example.philips.login.entities.CredentialsEntity;
import com.example.philips.login.models.CredentialsDTO;

public class CredentialsMapper {
    public static CredentialsEntity toEntity(CredentialsDTO credentials) {
        return new CredentialsEntity(credentials.username(),credentials.password(),credentials.role());
    }
}
