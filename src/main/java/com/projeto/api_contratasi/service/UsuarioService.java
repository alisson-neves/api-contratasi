package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.UsuarioDto;
import com.projeto.api_contratasi.entity.UsuarioEntity;
import com.projeto.api_contratasi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //CREATE
    public void inserir(UsuarioDto usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuarioEntity);
    }

    //READ
    public List<UsuarioDto> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }

    //UPDATE
    public UsuarioDto alterar (UsuarioDto usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        return new UsuarioDto(usuarioRepository.save(usuarioEntity));
    }

    //DELETE
    public void excluir (Long id){
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDto buscarPorId(Long id){
        return new UsuarioDto(usuarioRepository.findById(id).get());
    }

}
