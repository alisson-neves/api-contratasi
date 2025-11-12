package com.projeto.api_contratasi.controller;

import com.projeto.api_contratasi.dto.UsuarioDto;
import com.projeto.api_contratasi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario") //End para mapeamento da classe
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioDto> listarTodos(){

        return usuarioService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody UsuarioDto usuario){

        usuarioService.inserir(usuario);
    }

    @PutMapping
    public UsuarioDto alterar(@RequestBody UsuarioDto usuario){
        return usuarioService.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        usuarioService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
