package br.edu.utfpr.sistema_monitoramento.dtos;

import java.util.UUID;

public record SensorDTO(String tipo, String status, UUID dispositivoId) {

}
