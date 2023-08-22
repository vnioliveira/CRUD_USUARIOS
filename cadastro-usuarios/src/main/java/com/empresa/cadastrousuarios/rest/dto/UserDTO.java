package com.empresa.cadastrousuarios.rest.dto;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import com.empresa.cadastrousuarios.domain.model.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
@Builder
public class UserDTO {

    private String nome;
    private String username;
//    private String foto;
    private String cep;
    private String email;
    private LocalDateTime dataNascimento;
    private String sexo;
    private String tipoUsuario;
    private String cpfCnpj;
    private EnderecoDTO endereco;

}
