package com.projeto.api_contratasi.security.jwt;

import com.projeto.api_contratasi.service.UserDetailsImpl;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {

    @Value("${contrata.jwtSecret}")
    private String jwtSecret;

    @Value("${contrata.jwtExpirationMs}")
    private int jwtExpirationMs; //tempo de duração do token

    public String generateTokenFromUserDetailsImpl(UserDetailsImpl userDatail){
        return Jwts.builder().setSubject(userDatail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey(){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
                return key;
    }

    public String getUsernameToken(String token){
        return Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Token Inválido" + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("Token Expirado" + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Argumento Inválido" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("Token não suportado" + e.getMessage());
        }
        return false;
    }
}
