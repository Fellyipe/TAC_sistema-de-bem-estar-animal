package br.edu.utfpr.sistema_monitoramento.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.sistema_monitoramento.dtos.AviarioDTO;
import br.edu.utfpr.sistema_monitoramento.exception.NotFoundException;
import br.edu.utfpr.sistema_monitoramento.models.Aviario;
import br.edu.utfpr.sistema_monitoramento.repositories.AviarioRepository;

@Service
public class AviarioService {

    private final AviarioRepository repository;

    public AviarioService(AviarioRepository repository) {
        this.repository = repository;
    }

    public Aviario save(AviarioDTO dto) {
        var aviario = new Aviario();
        BeanUtils.copyProperties(dto, aviario);
        aviario.setNome(dto.nome());
        aviario.setCapacidadeMaxima(dto.capacidadeMaxima());
        aviario.setLocalizacao(dto.localizacao());
        aviario.setAtivo(dto.ativo());
        aviario.setLotes(dto.lotes());
        return repository.save(aviario);
    }

    public Page<Aviario> findAll(int pagina, int tamanho) {
        return repository.findAll(PageRequest.of(pagina, tamanho));
    }

    public Aviario findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Aviartio com ID: " + id + " não encontrado."));
    }

    public Aviario update(String id, AviarioDTO dto) {
        var aviarioExistente = findById(id);
        BeanUtils.copyProperties(dto, aviarioExistente, "id");
        aviarioExistente.setNome(dto.nome());
        aviarioExistente.setCapacidadeMaxima(dto.capacidadeMaxima());
        aviarioExistente.setLocalizacao(dto.localizacao());
        aviarioExistente.setAtivo(dto.ativo());
        aviarioExistente.setLotes(dto.lotes());
        return repository.save(aviarioExistente);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
