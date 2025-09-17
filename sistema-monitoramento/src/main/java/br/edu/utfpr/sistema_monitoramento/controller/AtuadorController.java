package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.sistema_monitoramento.dtos.AtuadorDTO;
import br.edu.utfpr.sistema_monitoramento.models.Atuador;
import br.edu.utfpr.sistema_monitoramento.services.AtuadorService;

@RestController
@RequestMapping("/atuadores")
public class AtuadorController {

    private final AtuadorService service;

    public AtuadorController(AtuadorService service) {
        this.service = service;
    }

    @PostMapping
    public Atuador save(@RequestBody AtuadorDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Atuador update(@PathVariable String id, @RequestBody AtuadorDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Atuador> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Atuador findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
