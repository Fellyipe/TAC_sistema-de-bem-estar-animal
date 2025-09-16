package br.edu.utfpr.sistema_monitoramento.dtos;

import br.edu.utfpr.sistema_monitoramento.models.Dispositivo;

public record SensorDTO(String tipo, String status, Dispositivo dispositivo) {

}
