package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import com.empresa.cadastrousuarios.domain.repository.EnderecoRepository;
import com.empresa.cadastrousuarios.rest.dto.EnderecoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = repository.findAll();
        return enderecos.stream()
                .map(this::buildEnderecoDTO)
                .collect(Collectors.toList());
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = repository.findById(id).orElse(null);
        assert endereco != null;
        return buildEnderecoDTO(endereco);
    }

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {

        var endereco = buildEndereco(enderecoDTO);
        Endereco enderecoSalvo = repository.save(endereco);
        return buildEnderecoDTO(enderecoSalvo);
    }

    public EnderecoDTO atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {

        if (repository.existsById(id)) {
            Endereco enderecoAtualizado = buildEndereco(enderecoDTO);
            enderecoAtualizado.setId(id);
            Endereco enderecoSalvo = repository.save(enderecoAtualizado);
            return buildEnderecoDTO(enderecoSalvo);
        }
        return null;
    }

    public void removerEndereco(Long id) {
        repository.deleteById(id);
    }

    private EnderecoDTO buildEnderecoDTO(Endereco enderecoSalvo) {
        return EnderecoDTO.builder()
                .cep(enderecoSalvo.getCep())
                .logradouro(enderecoSalvo.getLogradouro())
                .bairro(enderecoSalvo.getBairro())
                .cidade(enderecoSalvo.getCidade())
                .estado(enderecoSalvo.getEstado())
                .build();
    }

    private static Endereco buildEndereco(EnderecoDTO enderecoDTO) {
        return Endereco.builder()
                .cep(enderecoDTO.getCep())
                .logradouro(enderecoDTO.getLogradouro())
                .bairro(enderecoDTO.getBairro())
                .cidade(enderecoDTO.getCidade())
                .estado(enderecoDTO.getEstado())
                .build();
    }
}

