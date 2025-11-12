package com.projeto.api_contratasi.service;

import com.projeto.api_contratasi.dto.PerfilDto;
import com.projeto.api_contratasi.entity.PerfilEntity;
import com.projeto.api_contratasi.repository.PerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository perfilRepository;

    public void inserir(PerfilDto perfil){
        PerfilEntity perfilEntity = new PerfilEntity(perfil);
        perfilRepository.save(perfilEntity);
    }

    public List<PerfilDto> listarTodos(){
        List<PerfilEntity> perfis = perfilRepository.findAll();
        return perfis.stream().map(PerfilDto::new).toList();
    }

    public PerfilDto alterar (PerfilDto perfil){
        PerfilEntity perfilEntity = new PerfilEntity(perfil);
        return new PerfilDto(perfilRepository.save(perfilEntity));
    }

    public void excluir (Long id){
        PerfilEntity perfil = perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exclusão inváida! Não foi possivel encontrar o Perfil de ID: " + id));
        perfilRepository.delete(perfil);
    }

    public PerfilDto buscarPorId(Long id){

        return new PerfilDto(perfilRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não foi possivel encontrar o Perfil de ID: " + id)));
    }
}
