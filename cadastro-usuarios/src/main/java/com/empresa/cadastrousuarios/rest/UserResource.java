package com.empresa.cadastrousuarios.rest;

import com.empresa.cadastrousuarios.domain.model.User;
import com.empresa.cadastrousuarios.domain.service.UserService;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService service;

    public UserResource(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<UserDTO> listarUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UserDTO buscarUsuarioPorId(@PathVariable Long id) {
        return service.buscarUsuarioPorId(id);
    }

    @PostMapping
    @Transactional
    public User cadastrarUsuario(@RequestBody UserDTO usuarioRequest) {
        return service.cadastrarUsuario(usuarioRequest);
    }

    @PutMapping("/{id}")
    @Transactional
    public UserDTO atualizarUsuario(@PathVariable Long id, @RequestBody UserDTO usuarioRequest) {
        return service.atualizarUsuario(id, usuarioRequest);
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable Long id) {
        service.removerUsuario(id);
    }
}
