package com.projeto.api_contratasi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import java.util.UUID;

@Entity
@Table(name = "tb_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private UUID empresa_id;

    @NotBlank(message = "O nome fantasia é obrigatório")
    @Column(nullable = false)
    private String nomeFantasia;

    @NotBlank(message = "A razão social é obrigatória")
    @Column(nullable = false, unique = true) // Razão Social deve ser única
    private String razaoSocial;

    @NotBlank(message = "O CNPJ é obrigatório")
    @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 dígitos")
    @Column(nullable = false, unique = true) // CNPJ deve ser único
    private String cnpj;


    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vaga> vagas;

}