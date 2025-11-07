package com.projeto.api_contratasi.entity;

import com.projeto.api_contratasi.dto.EnderecoDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "CSI_ENDERECO")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class EnderecoEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private String numero;
    @Column
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    private String estado;

    public EnderecoEntity(EnderecoDto endereco){
        BeanUtils.copyProperties(endereco,this);
    }

    //montar estrategia de validação do Cep

}
