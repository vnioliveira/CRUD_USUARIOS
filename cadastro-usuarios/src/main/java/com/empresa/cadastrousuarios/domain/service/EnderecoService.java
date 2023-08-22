package com.empresa.cadastrousuarios.domain.service;

import com.empresa.cadastrousuarios.domain.mapper.EnderecoMapper;
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

    private final EnderecoMapper mapper;

    public List<EnderecoDTO> listarEnderecos() {
        List<Endereco> enderecos = repository.findAll();
        return enderecos.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = repository.findById(id).orElse(null);
        return mapper.toDto(endereco);
    }

    public EnderecoDTO cadastrarEndereco(EnderecoDTO enderecoDTO) {

        Endereco endereco = mapper.toEntity(enderecoDTO);
        Endereco enderecoSalvo = repository.save(endereco);
        return mapper.toDto(enderecoSalvo);
    }

    public EnderecoDTO atualizarEndereco(Long id, EnderecoDTO enderecoDTO) {

        if (repository.existsById(id)) {
            Endereco enderecoAtualizado = mapper.toEntity(enderecoDTO);
            enderecoAtualizado.setId(id);
            Endereco enderecoSalvo = repository.save(enderecoAtualizado);
            return mapper.toDto(enderecoSalvo);
        }
        return null;
    }

    public void removerEndereco(Long id) {
        repository.deleteById(id);
    }
}

