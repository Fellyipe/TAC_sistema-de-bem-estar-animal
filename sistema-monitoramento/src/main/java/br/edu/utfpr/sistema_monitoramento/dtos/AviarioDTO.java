package br.edu.utfpr.sistema_monitoramento.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record AviarioDTO(
    @NotBlank(message = "Não pode ser vazio") @Size(max = 255) String nome, 
    @NotNull(message = "Não pode ser nulo") @Positive Integer capacidadeMaxima, 
    @NotBlank(message = "Não pode ser vazio") @Size(max = 255) String localizacao, 
    @NotNull(message = "Não pode ser vazio") Boolean ativo) {

}
