package br.edu.utfpr.sistema_monitoramento.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_person")
public class Pessoa {

    @Id
    private UUID id = UUID.randomUUID();

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(unique = true, nullable = false, length = 200)
    private String email;

}
