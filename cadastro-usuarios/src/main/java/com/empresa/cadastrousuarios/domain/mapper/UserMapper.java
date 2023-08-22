package com.empresa.cadastrousuarios.domain.mapper;

import com.empresa.cadastrousuarios.domain.model.User;
import com.empresa.cadastrousuarios.rest.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = EnderecoMapper.class)
public interface UserMapper extends EntityMapper<UserDTO, User >{

    UserDTO toUserDTO(User user);
    User toUser(UserDTO userDTO);
}
