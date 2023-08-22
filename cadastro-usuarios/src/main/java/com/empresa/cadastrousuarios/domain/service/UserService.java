package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import com.empresa.cadastrousuarios.domain.model.User;
import com.empresa.cadastrousuarios.domain.repository.UserRepository;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Validated
public class UserService {

    private final UserRepository repository;

    private final EnderecoService enderecoService;

    public UserService(UserRepository repository, EnderecoService enderecoService) {
        this.repository = repository;
        this.enderecoService = enderecoService;
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

    public void cadastrarUsuario(@Validated UserDTO usuarioRequest) {

        Endereco endereco = enderecoService.cadastrarEndereco(usuarioRequest.getEndereco());
        User user = builUser(usuarioRequest);
        user.setEndereco(endereco);
        repository.save(user);

    }


    public ResponseEntity<Object> atualizarUsuario(Long id, UserDTO usuarioRequest) {
        if (repository.existsById(id)) {
            User usuarioAtualizado = builUser(usuarioRequest);
            usuarioAtualizado.setId(id);
            User usuarioSalvo = repository.save(usuarioAtualizado);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> removerUsuario(Long id) {
        UserDTO userDTO = buscarUsuarioPorId(id);
        if (userDTO != null){
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }


    public ResponseEntity<UserDTO> buscarUsuarioPorNome(String nome) {
        User user = repository.getUserByNome(nome);
        UserDTO userDTO = buildUserDTO(user);
        return ResponseEntity.ok(userDTO);
    }

    private static User builUser(UserDTO usuarioRequest) {
        return User.builder()
                .nome(usuarioRequest.getNome())
                .username(usuarioRequest.getUsername())
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
                .cep(usuario.getCep())
                .email(usuario.getEmail())
                .dataNascimento(usuario.getDataNascimento())
                .sexo(usuario.getSexo())
                .tipoUsuario(usuario.getTipoUsuario())
                .cpfCnpj(usuario.getCpfCnpj())
                .endereco(enderecoService.buildEnderecoDTO(usuario.getEndereco()))
                .build();
    }

}

