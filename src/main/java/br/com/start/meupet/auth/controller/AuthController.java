package br.com.start.meupet.auth.controller;

import br.com.start.meupet.auth.dto.AccessDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.start.meupet.auth.dto.AuthenticationDTO;
import br.com.start.meupet.auth.facade.AuthFacade;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController {
    private final AuthFacade authFacade;

    public AuthController(AuthFacade authFacade) {
        this.authFacade = authFacade;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<AccessDTO> login(@RequestBody @Valid AuthenticationDTO authDto) {
        return ResponseEntity.ok(authFacade.login(authDto));
    }
}
