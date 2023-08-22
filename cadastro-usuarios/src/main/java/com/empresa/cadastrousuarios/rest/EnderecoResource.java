package com.empresa.cadastrousuarios.rest;

import com.empresa.cadastrousuarios.domain.service.EnderecoService;
import com.empresa.cadastrousuarios.rest.dto.EnderecoDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
@RequiredArgsConstructor
public class EnderecoResource {

    private final EnderecoService service;

    @GetMapping
    public List<EnderecoDTO> listarEnderecos() {
        return service.listarEnderecos();
    }

    @GetMapping("/{id}")
    public EnderecoDTO buscarEnderecoPorId(@PathVariable Long id) {
        return service.buscarEnderecoPorId(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<EnderecoDTO> cadastrarEndereco(@RequestBody EnderecoDTO endereco) {
        service.cadastrarEndereco(endereco);
        return ResponseEntity.created(URI.create("api/enderecos")).build();
    }

    @PutMapping("/{id}")
    public EnderecoDTO atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoDTO endereco) {
        return service.atualizarEndereco(id, endereco);
    }

    @DeleteMapping("/{id}")
    public void removerEndereco(@PathVariable Long id) {
        service.removerEndereco(id);
    }
}
