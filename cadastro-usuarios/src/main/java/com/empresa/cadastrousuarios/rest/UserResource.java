package com.empresa.cadastrousuarios.rest;

import com.empresa.cadastrousuarios.domain.service.UserService;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {

    private final UserService service;

    @GetMapping
    public List<UserDTO> listarUsuarios() {
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UserDTO buscarUsuarioPorId(@PathVariable Long id) {
        return service.buscarUsuarioPorId(id);
    }

    @PostMapping
    public UserDTO cadastrarUsuario(@RequestBody UserDTO usuarioRequest) {
        return service.cadastrarUsuario(usuarioRequest);
    }

    @PutMapping("/{id}")
    public UserDTO atualizarUsuario(@PathVariable Long id, @RequestBody UserDTO usuarioRequest) {
        return service.atualizarUsuario(id, usuarioRequest);
    }

    @DeleteMapping("/{id}")
    public void removerUsuario(@PathVariable Long id) {
        service.removerUsuario(id);
    }
}
