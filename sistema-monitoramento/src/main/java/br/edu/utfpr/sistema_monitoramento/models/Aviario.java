package br.edu.utfpr.sistema_monitoramento.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_aviario")
public class Aviario extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(name = "capacidade_maxima", nullable = false)
    private Integer capacidadeMaxima;

    @Column(nullable = false)
    private String localizacao;

    @Column(nullable = false)
    private Boolean ativo;

    @OneToMany(mappedBy = "aviario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lote> lotes;
}
