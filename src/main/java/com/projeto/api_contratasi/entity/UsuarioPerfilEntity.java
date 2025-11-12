package com.projeto.api_contratasi.entity;

import com.projeto.api_contratasi.dto.PerfilDto;
import com.projeto.api_contratasi.dto.UsuarioDto;
import com.projeto.api_contratasi.dto.UsuarioPerfilDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "CSI_USUARIO_PERFIL")
@NoArgsConstructor
@Getter
@Setter
public class UsuarioPerfilEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @ManyToOne
    @JoinColumn(name = "ID_PERFIL")
    private PerfilEntity perfil;

    public UsuarioPerfilEntity(UsuarioPerfilDto usuarioPerfil){
        BeanUtils.copyProperties(usuarioPerfil, this);
        if (usuarioPerfil != null && usuarioPerfil.getUsario() != null){
            this.usuario = new UsuarioEntity(usuarioPerfil.getUsario());
        }
        if (usuarioPerfil != null && usuarioPerfil.getPerfil() != null){
            this.perfil = new PerfilEntity(usuarioPerfil.getPerfil());
        }
    }
}
