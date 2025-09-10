package br.edu.utfpr.sistema_monitoramento.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_lotes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lote {

    private UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "aviario_id", nullable = false)
    private Aviario aviario;
}
