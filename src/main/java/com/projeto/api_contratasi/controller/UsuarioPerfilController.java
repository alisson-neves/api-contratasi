package com.projeto.api_contratasi.controller;

import com.projeto.api_contratasi.dto.UsuarioPerfilDto;
import com.projeto.api_contratasi.service.UsuarioPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value="/usuario-perfil")
public class UsuarioPerfilController {

    @Autowired
    private UsuarioPerfilService usuarioPerfilService;

    @GetMapping
    public List<UsuarioPerfilDto> listarTodos(){

        return usuarioPerfilService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioPerfilDto usuarioPerfil){

        usuarioPerfilService.inserir(usuarioPerfil);
    }

    @PutMapping
    public UsuarioPerfilDto alterar(@RequestBody UsuarioPerfilDto usuarioPerfil){

        return usuarioPerfilService.alterar(usuarioPerfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        usuarioPerfilService.excluir(id);
        return ResponseEntity.ok().build();
    }
}

