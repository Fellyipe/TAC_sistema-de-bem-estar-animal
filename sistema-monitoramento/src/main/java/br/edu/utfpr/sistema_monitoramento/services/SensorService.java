package br.edu.utfpr.sistema_monitoramento.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.sistema_monitoramento.dtos.SensorDTO;
import br.edu.utfpr.sistema_monitoramento.exception.NotFoundException;
import br.edu.utfpr.sistema_monitoramento.models.Sensor;
import br.edu.utfpr.sistema_monitoramento.repositories.SensorRepository;

@Service
public class SensorService {

    private final SensorRepository repository;

    public SensorService(SensorRepository repository) {
        this.repository = repository;
    }

    public Sensor save(SensorDTO dto) {
        var sensor = new Sensor();
        BeanUtils.copyProperties(dto, sensor);
        sensor.setTipo(dto.tipo());
        sensor.setStatus(dto.status());
        sensor.setDispositivo(dto.dispositivo());
        return repository.save(sensor);
    }

    public Page<Sensor> findAll(int pagina, int tamanho) {
        return repository.findAll(PageRequest.of(pagina, tamanho));
    }

    public Sensor findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Sensor com ID: " + id + " não encontrado."));
    }

    public Sensor update(String id, SensorDTO dto) {
        var sensorExistente = findById(id);
        BeanUtils.copyProperties(dto, sensorExistente, "id");
        sensorExistente.setTipo(dto.tipo());
        sensorExistente.setStatus(dto.status());
        sensorExistente.setDispositivo(dto.dispositivo());
        return repository.save(sensorExistente);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
