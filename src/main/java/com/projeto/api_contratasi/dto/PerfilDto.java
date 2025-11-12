package com.projeto.api_contratasi.dto;

import com.projeto.api_contratasi.entity.PerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDto {
    private Long id;
    private String fotoPerfil;
    private String linkedin;
    private String site;

    public PerfilDto(PerfilEntity perfil){
        BeanUtils.copyProperties(perfil,this);
    }
}
