package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.entity.UsuarioEntity;
import com.projeto.api_contratasi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
   @Autowired
   private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioEntity usuario = usuarioRepository.findByLogin(username).get();
        return UserDetailsImpl.build(usuario);
    }
}
