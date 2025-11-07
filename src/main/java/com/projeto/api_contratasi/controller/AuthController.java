package com.projeto.api_contratasi.controller;

import com.projeto.api_contratasi.dto.AuthenticationDto;
import com.projeto.api_contratasi.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDto authDto){
        return ResponseEntity.ok(authService.login(authDto));
    }
}
