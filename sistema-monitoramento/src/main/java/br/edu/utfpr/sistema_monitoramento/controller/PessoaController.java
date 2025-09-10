package br.edu.utfpr.sistema_monitoramento.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.sistema_monitoramento.models.Pessoa;
import br.edu.utfpr.sistema_monitoramento.repositories.PessoaRepository;

@RestController
@RequestMapping("/person")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> getPerson() {
        return pessoaRepository.findAll();
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Pessoa> getPersonById(@PathVariable String personId) {
        var uuid = UUID.fromString(personId);
        var result = pessoaRepository.findById(uuid);

        return result.isPresent() ? ResponseEntity.ok(result.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Pessoa create(@RequestBody Pessoa entity) {
        //TODO: process POST request
        System.out.println(entity);
        pessoaRepository.save(entity);
        return entity;
    }

}
