package br.edu.utfpr.sistema_monitoramento.dtos;

import br.edu.utfpr.sistema_monitoramento.models.Dispositivo;

public record AtuadorDTO(String tipo, String status, Dispositivo dispositivo) {

}
