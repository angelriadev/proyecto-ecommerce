package com.example.philips.login.controllers;

import com.example.philips.login.configuration.JwtUtils;
import com.example.philips.login.entities.CredentialsEntity;
import com.example.philips.login.entities.LoginRequest;
import com.example.philips.login.models.CredentialsDTO;
import com.example.philips.login.services.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class CredentialsController {
    @Autowired
    private CredentialsService credentialsService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.username(),
                        loginRequest.password()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateClaims(authentication.getName());
        return ResponseEntity.ok(jwt);
    }
    @PostMapping("/register")
    public ResponseEntity<CredentialsEntity> registerUser(@RequestBody  CredentialsDTO credentialsDTO){
        return  new ResponseEntity<>(credentialsService.save(credentialsDTO), HttpStatus.CREATED);
    }

}
