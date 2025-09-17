package br.edu.utfpr.sistema_monitoramento.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.sistema_monitoramento.dtos.AtuadorDTO;
import br.edu.utfpr.sistema_monitoramento.exception.NotFoundException;
import br.edu.utfpr.sistema_monitoramento.models.Atuador;
import br.edu.utfpr.sistema_monitoramento.repositories.AtuadorRepository;

@Service
public class AtuadorService {

    private final AtuadorRepository repository;

    public AtuadorService(AtuadorRepository repository) {
        this.repository = repository;
    }

    public Atuador save(AtuadorDTO dto) {
        var atuador = new Atuador();
        BeanUtils.copyProperties(dto, atuador);
        atuador.setTipo(dto.tipo());
        atuador.setStatus(dto.status());
        atuador.setDispositivo(dto.dispositivo());
        return repository.save(atuador);
    }

    public Page<Atuador> findAll(int pagina, int tamanho) {
        return repository.findAll(PageRequest.of(pagina, tamanho));
    }

    public Atuador findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Atuador com ID: " + id + " não encontrado."));
    }

    public Atuador update(String id, AtuadorDTO dto) {
        var atuadorExistente = findById(id);
        BeanUtils.copyProperties(dto, atuadorExistente, "id");
        atuadorExistente.setTipo(dto.tipo());
        atuadorExistente.setStatus(dto.status());
        atuadorExistente.setDispositivo(dto.dispositivo());
        return repository.save(atuadorExistente);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
