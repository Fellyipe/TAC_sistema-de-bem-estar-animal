package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.edu.utfpr.sistema_monitoramento.models.Aviario;
import br.edu.utfpr.sistema_monitoramento.repositories.AviarioRepository;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aviarios")
public class AviarioController {

    @Autowired
    private AviarioRepository aviarioRepository;

    @GetMapping
    public List<Aviario> getAviarios() {
        return aviarioRepository.findAll();
    }

    @GetMapping("/{aviarioId}")
    public ResponseEntity<Aviario> getAviarioById(@PathVariable String aviarioId) {
        var uuid = UUID.fromString(aviarioId);
        var result = aviarioRepository.findById(uuid);

        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Aviario create(@RequestBody Aviario entity) {
        aviarioRepository.save(entity);
        return entity;
    }
}
