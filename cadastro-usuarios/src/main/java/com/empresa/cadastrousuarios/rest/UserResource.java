package com.empresa.cadastrousuarios.rest;

import com.empresa.cadastrousuarios.domain.service.UserService;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Object> cadastrarUsuario(@RequestBody UserDTO usuarioRequest) {
        service.cadastrarUsuario(usuarioRequest);
        return ResponseEntity.created(URI.create("/users")).build();
    }

    @GetMapping("/name/{nome}")
    public ResponseEntity<UserDTO> buscarUsuarioPorNome(@PathVariable String nome) {
        return service.buscarUsuarioPorNome(nome);
    }

    @GetMapping
    public List<UserDTO> listarUsuarios() {
        return service.listarUsuarios();
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizarUsuario(@PathVariable Long id, @RequestBody UserDTO usuarioRequest) {
        return service.atualizarUsuario(id, usuarioRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removerUsuario(@PathVariable Long id) {
        return service.removerUsuario(id);
    }
}
