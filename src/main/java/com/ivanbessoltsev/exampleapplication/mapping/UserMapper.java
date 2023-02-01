package com.ivanbessoltsev.exampleapplication.mapping;

import com.ivanbessoltsev.exampleapplication.model.dto.user.CreateUserDTO;
import com.ivanbessoltsev.exampleapplication.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toUser(CreateUserDTO createUserDTO);

    CreateUserDTO toDTO(User user);


}
