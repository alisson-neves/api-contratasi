package com.projeto.api_contratasi.controller;

import com.projeto.api_contratasi.dto.PerfilDto;
import com.projeto.api_contratasi.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil")
@CrossOrigin
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public List<PerfilDto> listarTodos(){
        return perfilService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody PerfilDto perfil){
        perfilService.inserir(perfil);
    }

    @PutMapping
    public PerfilDto alterar(@RequestBody PerfilDto perfil){
        return perfilService.alterar(perfil);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        perfilService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
