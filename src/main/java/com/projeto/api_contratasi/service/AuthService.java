package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.AcessDto;
import com.projeto.api_contratasi.dto.AuthenticationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.projeto.api_contratasi.security.jwt.JwtUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDto login(AuthenticationDto authDto) {
        try {
            //Credencial para o Spring
            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());
            //Prepara para a Autentificação
            Authentication authentication = authenticationManager.authenticate(userAuth);
            //busca User Logado
            UserDetailsImpl userAuthenticate = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateTokenFromUserDetailsImpl(userAuthenticate);

            AcessDto acessDto = new AcessDto(token);

            return acessDto;

        }catch (BadCredentialsException e){
            //Aqui cai os Logins e Senhas invalidos!
            return new AcessDto("Erro: Acesso Negado!");
        }
    }
}
