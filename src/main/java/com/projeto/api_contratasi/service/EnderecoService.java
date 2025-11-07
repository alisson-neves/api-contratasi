package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.EnderecoDto;
import com.projeto.api_contratasi.entity.EnderecoEntity;
import com.projeto.api_contratasi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    //Create
    public void inserir(EnderecoDto endereco){
        EnderecoEntity enderecoEntity = new EnderecoEntity(endereco);
        enderecoRepository.save(enderecoEntity);
    }

    //Read
    public List<EnderecoDto> listarTodos(){
        List<EnderecoEntity> enderecos = enderecoRepository.findAll();
        return enderecos.stream().map(EnderecoDto::new).toList();
    }

    //Update
    public EnderecoDto alterar (EnderecoDto endereco){
        EnderecoEntity enderecoEntity = new EnderecoEntity(endereco);
        return new EnderecoDto(enderecoRepository.save(enderecoEntity));
    }

    //Delete
    public void excluir (int id){
        EnderecoEntity endereco = enderecoRepository.findById(id).get();
        enderecoRepository.delete(endereco);
    }

}
