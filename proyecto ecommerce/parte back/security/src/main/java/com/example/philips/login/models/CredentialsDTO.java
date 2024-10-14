package com.example.philips.login.models;

import com.example.philips.login.entities.Roles;

public record CredentialsDTO(String username, String password, Roles role) {
}
