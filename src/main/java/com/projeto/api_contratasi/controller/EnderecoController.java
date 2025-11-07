package com.projeto.api_contratasi.controller;

import com.projeto.api_contratasi.dto.EnderecoDto;
import com.projeto.api_contratasi.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDto> listarTodos(){
        return enderecoService.listarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody EnderecoDto endereco){
        enderecoService.inserir(endereco);
    }

    @PutMapping
    public EnderecoDto alterar(@RequestBody EnderecoDto endereco){
        return enderecoService.alterar(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") int id){
        enderecoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
