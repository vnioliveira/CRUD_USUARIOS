package com.empresa.cadastrousuarios.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100, name = "nome")
    private String nome;

    @Column(nullable = false, unique = true, length = 50, name = "username")
    private String username;

    @Column(nullable = false, name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @Column(length = 8, name = "cep")
    private String cep;

    @Column(nullable = false, unique = true, length = 100, name = "email")
    private String email;

    @Column(nullable = false, name = "data_nascimento")
    private LocalDateTime dataNascimento;

    @Column(length = 14, name = "cpf_cnpj")
    private String cpfCnpj;

    @Column(name = "sexo", nullable = false)
    public String sexo;

    @Column(name = "tipo", nullable = false)
    public String tipoUsuario;
}

