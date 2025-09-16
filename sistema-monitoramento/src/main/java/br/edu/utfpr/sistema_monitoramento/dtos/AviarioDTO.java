package br.edu.utfpr.sistema_monitoramento.dtos;

import java.util.List;

import br.edu.utfpr.sistema_monitoramento.models.Lote;

public record AviarioDTO(String nome, Integer capacidadeMaxima, String localizacao, Boolean ativo, List<Lote> lotes) {

}
