package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.sistema_monitoramento.dtos.LoteDTO;
import br.edu.utfpr.sistema_monitoramento.models.Lote;
import br.edu.utfpr.sistema_monitoramento.services.LoteService;

@RestController
@RequestMapping("/lotes")
public class LoteController {

    private final LoteService service;

    public LoteController(LoteService service) {
        this.service = service;
    }

    @PostMapping
    public Lote save(@RequestBody LoteDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Lote update(@PathVariable String id, @RequestBody LoteDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Lote> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Lote findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
