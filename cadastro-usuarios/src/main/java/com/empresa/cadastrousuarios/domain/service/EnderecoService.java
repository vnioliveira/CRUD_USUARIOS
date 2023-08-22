package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import com.empresa.cadastrousuarios.domain.repository.EnderecoRepository;
import com.empresa.cadastrousuarios.rest.dto.EnderecoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public Endereco cadastrarEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = buildEndereco(enderecoDTO);
        return repository.save(endereco);
    }

    public EnderecoDTO buildEnderecoDTO(Endereco enderecoSalvo) {
        return EnderecoDTO.builder()
                .cep(enderecoSalvo.getCep())
                .logradouro(enderecoSalvo.getLogradouro())
                .bairro(enderecoSalvo.getBairro())
                .cidade(enderecoSalvo.getCidade())
                .estado(enderecoSalvo.getEstado())
                .build();
    }

    public static Endereco buildEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .cep(enderecoDTO.getCep())
                .logradouro(enderecoDTO.getLogradouro())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .build();
    }
}

