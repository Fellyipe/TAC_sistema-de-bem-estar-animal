package br.edu.utfpr.sistema_monitoramento.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.sistema_monitoramento.dtos.DispositivoDTO;
import br.edu.utfpr.sistema_monitoramento.exception.NotFoundException;
import br.edu.utfpr.sistema_monitoramento.models.Dispositivo;
import br.edu.utfpr.sistema_monitoramento.repositories.DispositivoRepository;

@Service
public class DispositivoService {

    private final DispositivoRepository repository;

    public DispositivoService(DispositivoRepository repository) {
        this.repository = repository;
    }

    public Dispositivo save(DispositivoDTO dto) {
        var dispositivo = new Dispositivo();
        BeanUtils.copyProperties(dto, dispositivo);
        dispositivo.setSerial(dto.serial());
        dispositivo.setStatus(dto.Status());
        dispositivo.setAviario(dto.aviario());
        return repository.save(dispositivo);
    }

    public Page<Dispositivo> findAll(int pagina, int tamanho) {
        return repository.findAll(PageRequest.of(pagina, tamanho));
    }

    public Dispositivo findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Dispositivo com ID: " + id + " não encontrado."));
    }

    public Dispositivo update(String id, DispositivoDTO dto) {
        var dispositivoExistente = findById(id);
        BeanUtils.copyProperties(dto, dispositivoExistente, "id");
        dispositivoExistente.setSerial(dto.serial());
        dispositivoExistente.setStatus(dto.Status());
        dispositivoExistente.setAviario(dto.aviario());
        return repository.save(dispositivoExistente);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
