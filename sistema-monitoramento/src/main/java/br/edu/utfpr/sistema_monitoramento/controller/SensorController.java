package br.edu.utfpr.sistema_monitoramento.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import br.edu.utfpr.sistema_monitoramento.dtos.SensorDTO;
import br.edu.utfpr.sistema_monitoramento.models.Sensor;
import br.edu.utfpr.sistema_monitoramento.services.SensorService;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService service;

    public SensorController(SensorService service) {
        this.service = service;
    }

    @PostMapping
    public Sensor save(@RequestBody SensorDTO dto) {
        return service.save(dto);
    }

    @PutMapping("/{id}")
    public Sensor update(@PathVariable String id, @RequestBody SensorDTO dto) {
        return service.update(id, dto);
    }

    @GetMapping
    public Page<Sensor> findAll(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanho) {
        return service.findAll(pagina, tamanho);
    }

    @GetMapping("/{id}")
    public Sensor findById(@PathVariable String id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
