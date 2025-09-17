package br.edu.utfpr.sistema_monitoramento.dtos;

import java.util.UUID;

public record DispositivoDTO(String serial, String Status, UUID aviarioId) {

}
