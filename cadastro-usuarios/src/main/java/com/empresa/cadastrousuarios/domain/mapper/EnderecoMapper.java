package com.empresa.cadastrousuarios.domain.mapper;

import com.empresa.cadastrousuarios.domain.model.Endereco;
import com.empresa.cadastrousuarios.rest.dto.EnderecoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface EnderecoMapper extends EntityMapper<EnderecoDTO, Endereco> {
    EnderecoDTO toEnderecoDTO(Endereco endereco);
    Endereco toEndereco(EnderecoDTO enderecoDTO);
}

