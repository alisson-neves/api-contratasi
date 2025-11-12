package com.projeto.api_contratasi.entity;

import com.projeto.api_contratasi.dto.PerfilDto;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "CSI_PERFIL")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class PerfilEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    @Column
    private String fotoPerfil;

    @Column
    private String linkedin;

    @Column
    private String site;

    public PerfilEntity(PerfilDto perfil){
        BeanUtils.copyProperties(perfil,this);
    }
}
