package com.projeto.api_contratasi.entity;

import com.projeto.api_contratasi.dto.EnderecoDto;
import com.projeto.api_contratasi.dto.UsuarioDto;
import com.projeto.api_contratasi.entity.Enuns.EstadoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Entity
@Table(name = "CSI_USUARIO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_ENDERECO")
    private EnderecoEntity endereco;

    @Enumerated(EnumType.STRING)
    private EstadoUsuario estado;

    public UsuarioEntity(UsuarioDto usuario){
        BeanUtils.copyProperties(usuario,this);
        if (usuario != null && usuario.getEndereco() != null){
            this.endereco = new EnderecoEntity(usuario.getEndereco());
        }
    }


}
