package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.sistema_monitoramento.dtos.DispositivoDTO;
import br.edu.utfpr.sistema_monitoramento.models.Dispositivo;
import br.edu.utfpr.sistema_monitoramento.services.DispositivoService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    private final DispositivoService service;

    public DispositivoController(DispositivoService service) {
        this.service = service;
    }

    @PostMapping
    public Dispositivo save(@RequestBody DispositivoDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Dispositivo update(@PathVariable String id, @RequestBody DispositivoDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Dispositivo> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Dispositivo findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
