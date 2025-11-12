package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.PerfilDto;
import com.projeto.api_contratasi.dto.UsuarioPerfilDto;
import com.projeto.api_contratasi.entity.UsuarioPerfilEntity;
import com.projeto.api_contratasi.repository.UsuarioPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsuarioPerfilService {

    @Autowired
    private UsuarioPerfilRepository usuarioPerfilRepository;

    public  void inserir(UsuarioPerfilDto usuarioPerfil){
        UsuarioPerfilEntity usuarioPerfilEntity = new UsuarioPerfilEntity(usuarioPerfil);
        usuarioPerfilRepository.save(usuarioPerfilEntity);
    }

    public List<UsuarioPerfilDto> listarTodos(){
        List<UsuarioPerfilEntity> usuarioperfis = usuarioPerfilRepository.findAll();
        return usuarioperfis.stream().map(UsuarioPerfilDto::new).toList();
    }

    public UsuarioPerfilDto alterar (UsuarioPerfilDto usuarioPerfil){
        UsuarioPerfilEntity usuarioPerfilEntity = new UsuarioPerfilEntity(usuarioPerfil);
        return new UsuarioPerfilDto(usuarioPerfilRepository.save(usuarioPerfilEntity));
    }

    public void excluir (Long id){
        UsuarioPerfilEntity usuarioPerfil = usuarioPerfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Erro na Exclusão do Vínculo Usuário-Perfil! Verifique o ID: " + id));
        usuarioPerfilRepository.delete(usuarioPerfil);
    }

    public UsuarioPerfilDto buscarPorId(Long id){
        return new UsuarioPerfilDto(usuarioPerfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vínculo Usuário-Perfil não encontrado! Verifique o ID: " + id)));
    }
}
