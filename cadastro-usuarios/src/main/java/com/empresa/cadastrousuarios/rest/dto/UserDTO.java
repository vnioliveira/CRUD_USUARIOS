package com.empresa.cadastrousuarios.rest.dto;

import com.empresa.cadastrousuarios.domain.model.User;

import java.time.LocalDate;

public class UserDTO {

    private String nome;
    private String username;
    private String senha;
    private byte[] foto;
    private String cep;
    private String endereco;
    private String email;
    private LocalDate dataNascimento;
    private User.Sexo sexo;
    private User.TipoUsuario tipo;
    private String cpfCnpj;

}
