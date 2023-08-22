package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.model.User;
import com.empresa.cadastrousuarios.domain.repository.UserRepository;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> listarUsuarios() {
        List<User> usuarios = repository.findAll();

        return usuarios.stream()
                .map(this::buildUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO buscarUsuarioPorId(Long id) {
        User usuario = repository.findById(id).orElse(null);
        assert usuario != null;
        return buildUserDTO(usuario);
    }

    public User cadastrarUsuario(UserDTO usuarioRequest) {
        User user = builUser(usuarioRequest);
        return repository.save(user);
    }


    public UserDTO atualizarUsuario(Long id, UserDTO usuarioRequest) {
        if (repository.existsById(id)) {
            User usuarioAtualizado = builUser(usuarioRequest);
            usuarioAtualizado.setId(id);
            User usuarioSalvo = repository.save(usuarioAtualizado);
            return buildUserDTO(usuarioSalvo);
        }
        return null;
    }

    public void removerUsuario(Long id) {
        repository.deleteById(id);
    }

    private static User builUser(UserDTO usuarioRequest) {
        return User.builder()
                .nome(usuarioRequest.getNome())
                .username(usuarioRequest.getUsername())
                .senha(usuarioRequest.getSenha())
//                .foto(converterParaBytes(usuarioRequest))
                .cep(usuarioRequest.getCep())
                .email(usuarioRequest.getEmail())
                .dataNascimento(usuarioRequest.getDataNascimento())
                .sexo(usuarioRequest.getSexo())
                .tipoUsuario(usuarioRequest.getTipoUsuario())
                .cpfCnpj(usuarioRequest.getCpfCnpj())
                .build();
    }

    private UserDTO buildUserDTO(User usuario) {
        return UserDTO.builder()
                .nome(usuario.getNome())
                .username(usuario.getUsername())
                .senha(usuario.getSenha())
                .cep(usuario.getCep())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .sexo(usuario.getSexo())
                .tipoUsuario(usuario.getTipoUsuario())
                .cpfCnpj(usuario.getCpfCnpj())
                .build();
    }

}

