package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.UsuarioDto;
import com.projeto.api_contratasi.entity.Enuns.EstadoUsuario;
import com.projeto.api_contratasi.entity.UsuarioEntity;
import com.projeto.api_contratasi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

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

    public void inserirNovoUsuario(UsuarioDto usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        usuarioEntity.setEstado(EstadoUsuario.ATIVO);
        usuarioEntity.setId(null);
        usuarioRepository.save(usuarioEntity);
    }

    //READ
    public List<UsuarioDto> listarTodos() {
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDto::new).toList();
    }

    //UPDATE
    public UsuarioDto alterar (UsuarioDto usuario){
        Optional<UsuarioEntity> usuarioExistente = usuarioRepository.findById(usuario.getId());
        if(usuarioExistente.isEmpty()){
            throw new RuntimeException("Alteração não permitida! Usuario não encontrado.");
        }
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        if (usuario.getSenha() != null && !usuario.getSenha().isEmpty()){
            usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
        }else {
            usuarioEntity.setSenha(usuarioExistente.get().getSenha());
        }
        return new UsuarioDto(usuarioRepository.save(usuarioEntity));
    }

    //DELETE
    public void excluir (Long id){
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Não foi possivel encontrar o Usuario de ID:" + id));
        usuarioRepository.delete(usuario);
    }

    public UsuarioDto buscarPorId(Long id){
        return new UsuarioDto(usuarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Esse Usuario não existe! Verifique o ID:" + id)));

    }

}
