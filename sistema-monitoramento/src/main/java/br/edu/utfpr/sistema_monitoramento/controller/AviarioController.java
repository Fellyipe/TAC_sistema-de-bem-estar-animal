package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.sistema_monitoramento.dtos.AviarioDTO;
import br.edu.utfpr.sistema_monitoramento.models.Aviario;
import br.edu.utfpr.sistema_monitoramento.services.AviarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/aviarios")
public class AviarioController {

    private final AviarioService service;

    public AviarioController(AviarioService service) {
        this.service = service;
    }

    @PostMapping
    public Aviario save(@Valid @RequestBody AviarioDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Aviario update(@PathVariable String id, @RequestBody AviarioDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Aviario> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Aviario findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
