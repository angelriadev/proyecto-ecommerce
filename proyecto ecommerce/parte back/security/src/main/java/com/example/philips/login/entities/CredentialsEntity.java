package com.example.philips.login.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "credentials")
public class CredentialsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Setter
    @Column(unique = true)
    private String username;
    @Setter
    private String password;
    @Setter
    private Roles role = Roles.USER;

    public CredentialsEntity(String username, String password, Roles role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
