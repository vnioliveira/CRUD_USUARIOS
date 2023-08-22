package com.empresa.cadastrousuarios.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "enderecos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 8, name = "cep")
    private String cep;

    @Column(length = 100, name = "logradouro")
    private String logradouro;

    @Column(length = 50, name = "bairro")
    private String bairro;

    @Column(length = 50, name = "cidade")
    private String cidade;

    @Column(length = 2, name = "estado")
    private String estado;

}
