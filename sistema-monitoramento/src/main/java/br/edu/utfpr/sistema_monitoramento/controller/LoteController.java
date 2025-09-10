package br.edu.utfpr.sistema_monitoramento.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.sistema_monitoramento.models.Lote;
import br.edu.utfpr.sistema_monitoramento.repositories.LoteRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
@RequestMapping("/lotes")
public class LoteController {

    @Autowired
    private LoteRepository loteRepository;

    @GetMapping
    public List<Lote> getLotes() {
        return loteRepository.findAll();
    }

    @GetMapping("/{loteId}")
    public ResponseEntity<Lote> getLoteById(@PathVariable String loteId) {
        var uuid = UUID.fromString(loteId);
        var result = loteRepository.findById(uuid);

        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Lote create(@RequestBody Lote entity) {
        loteRepository.save(entity);
        return entity;
    }

    @PutMapping("/{loteId}")
    public ResponseEntity<Lote> update(@PathVariable String loteId, @RequestBody Lote entity) {
        var uuid = UUID.fromString(loteId);
        if (!loteRepository.existsById(uuid)) {
            return ResponseEntity.notFound().build();
        }

        entity.setId(uuid);
        loteRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping("/{loteId}")
    public ResponseEntity<Void> delete(@PathVariable String loteId) {
        var uuid = UUID.fromString(loteId);
        if (!loteRepository.existsById(uuid)) {
            return ResponseEntity.notFound().build();
        }

        loteRepository.deleteById(uuid);
        return ResponseEntity.noContent().build();
    }
}
