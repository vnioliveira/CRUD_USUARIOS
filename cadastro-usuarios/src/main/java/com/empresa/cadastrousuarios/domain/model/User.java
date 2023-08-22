package com.empresa.cadastrousuarios.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String senha;

    @Lob
    private byte[] foto;

    @Column(length = 8) // Pode ser ajustado conforme a necessidade
    private String cep;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;

    @Column(length = 14)
    private String cpfCnpj;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    // Enum para Sexo
    public enum Sexo {
        MASCULINO, FEMININO
    }

    // Enum para TipoUsuario
    public enum TipoUsuario {
        PESSOA_FISICA, PESSOA_JURIDICA
    }
}

