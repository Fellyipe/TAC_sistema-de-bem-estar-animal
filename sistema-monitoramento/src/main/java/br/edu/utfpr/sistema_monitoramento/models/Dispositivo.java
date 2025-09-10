package br.edu.utfpr.sistema_monitoramento.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tb_dispositivo")
@EqualsAndHashCode(callSuper=false)
public class Dispositivo extends BaseEntity {

    private String serial;
    
    private String status;

    @ManyToOne
    @JoinColumn(name = "aviario_id", nullable = false)
    private Aviario aviario;

}
