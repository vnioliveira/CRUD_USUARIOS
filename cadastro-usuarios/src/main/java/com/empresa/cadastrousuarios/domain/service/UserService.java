package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.mapper.UserMapper;
import com.empresa.cadastrousuarios.domain.model.User;
import com.empresa.cadastrousuarios.domain.repository.UserRepository;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository repository;

    private final UserMapper mapper;

    public List<UserDTO> listarUsuarios() {
        List<User> usuarios = repository.findAll();
        return usuarios.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public UserDTO buscarUsuarioPorId(Long id) {
        User usuario = repository.findById(id).orElse(null);
        return mapper.toDto(usuario);
    }

    public UserDTO cadastrarUsuario(UserDTO usuarioRequest) {
        User usuario = mapper.toEntity(usuarioRequest);
        User usuarioSalvo = repository.save(usuario);
        return mapper.toDto(usuarioSalvo);
    }

    public UserDTO atualizarUsuario(Long id, UserDTO usuarioRequest) {
        if (repository.existsById(id)) {
            User usuarioAtualizado = mapper.toEntity(usuarioRequest);
            usuarioAtualizado.setId(id);
            User usuarioSalvo = repository.save(usuarioAtualizado);
            return mapper.toDto(usuarioSalvo);
        }
        return null;
    }

    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }
}

