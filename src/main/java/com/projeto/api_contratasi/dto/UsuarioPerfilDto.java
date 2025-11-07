package com.projeto.api_contratasi.dto;

import com.projeto.api_contratasi.entity.UsuarioPerfilEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@NoArgsConstructor
@Getter
@Setter
public class UsuarioPerfilDto {

    private long id;
    private UsuarioDto usario;
    private PerfilDto perfil;

    public UsuarioPerfilDto(UsuarioPerfilEntity usuarioPerfil){
        BeanUtils.copyProperties(usuarioPerfil, this);
        if (usuarioPerfil != null && usuarioPerfil.getUsuario() != null){
            this.usario = new UsuarioDto(usuarioPerfil.getUsuario());
        }
        if (usuarioPerfil != null && usuarioPerfil.getPerfil() != null){
            this.perfil = new PerfilDto(usuarioPerfil.getPerfil());
        }
    }
}
