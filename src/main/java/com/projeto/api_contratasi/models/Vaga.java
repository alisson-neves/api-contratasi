package com.projeto.api_contratasi.models;

// Anotações
import com.projeto.api_contratasi.enums.Modalidade;
import com.projeto.api_contratasi.enums.NivelExperiencia;
import com.projeto.api_contratasi.enums.StatusVaga;
import com.projeto.api_contratasi.enums.TipoContrato;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private UUID id;

    @NotBlank
    @Column(nullable = false)
    private String titulo;

    @NotBlank
    @Column(nullable = false)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private LocalDate dataInicio;

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate dataFim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id", nullable = false)
    @NotNull
    private Empresa empresa;

    @ManyToMany
    @JoinTable(
            name = "vaga_competencia",
            joinColumns = @JoinColumn(name = "vaga_id"),
            inverseJoinColumns = @JoinColumn(name = "competencia_id")
    )
    private List<Competencia> competencias;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Modalidade modalidade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NivelExperiencia nivelExperiencia;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoContrato tipoContrato;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVaga status;

    // Métodos
    @Override
    public String toString() {
        return super.toString();
    }
}