package br.edu.utfpr.sistema_monitoramento.dtos;

import br.edu.utfpr.sistema_monitoramento.models.Aviario;

public record DispositivoDTO(String serial, String Status, Aviario aviario) {

}
