package br.edu.utfpr.sistema_monitoramento.services;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.edu.utfpr.sistema_monitoramento.dtos.LoteDTO;
import br.edu.utfpr.sistema_monitoramento.exception.NotFoundException;
import br.edu.utfpr.sistema_monitoramento.models.Lote;
import br.edu.utfpr.sistema_monitoramento.repositories.LoteRepository;

@Service
public class LoteService {

    private final LoteRepository repository;

    public LoteService(LoteRepository repository) {
        this.repository = repository;
    }

    public Lote save(LoteDTO dto) {
        var lote = new Lote();
        BeanUtils.copyProperties(dto, lote);
        lote.setDescricao(dto.descricao());
        lote.setAviario(dto.aviario());
        return repository.save(lote);
    }

    public Page<Lote> findAll(int pagina, int tamanho) {
        return repository.findAll(PageRequest.of(pagina, tamanho));
    }

    public Lote findById(String id) {
        UUID uuid = UUID.fromString(id);
        return repository.findById(uuid)
                .orElseThrow(() -> new NotFoundException("Lote com ID: " + id + " não encontrado."));
    }

    public Lote update(String id, LoteDTO dto) {
        var loteExistente = findById(id);
        BeanUtils.copyProperties(dto, loteExistente, "id");
        loteExistente.setDescricao(dto.descricao());
        loteExistente.setAviario(dto.aviario());
        return repository.save(loteExistente);
    }

    public void delete(String id) {
        repository.delete(findById(id));
    }
}
