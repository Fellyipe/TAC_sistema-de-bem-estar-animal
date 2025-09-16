package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.sistema_monitoramento.dtos.PessoaDTO;
import br.edu.utfpr.sistema_monitoramento.models.Pessoa;
import br.edu.utfpr.sistema_monitoramento.services.PessoaService;

@RestController
@RequestMapping("/pessoas") // Alterado para o plural, que é uma convenção comum
public class PessoaController {

    private final PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @PostMapping
    public Pessoa save(@RequestBody PessoaDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Pessoa update(@PathVariable String id, @RequestBody PessoaDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Pessoa> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Pessoa findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }

}
