package com.projeto.api_contratasi.dto;

import com.projeto.api_contratasi.entity.Enuns.EstadoUsuario;
import com.projeto.api_contratasi.entity.UsuarioEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDto {

    private long id;

    private String nome;

    private String login;

    private String email;

    private String senha;

    private String telefone;

    private EnderecoDto endereco;

    private EstadoUsuario estado;

    public UsuarioDto(UsuarioEntity usuario){
        BeanUtils.copyProperties(usuario,this);
        if (usuario != null && usuario.getEndereco() != null){
            this.endereco = new EnderecoDto(usuario.getEndereco());
        }
    }
}
