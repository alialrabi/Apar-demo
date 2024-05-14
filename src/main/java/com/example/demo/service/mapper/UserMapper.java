package com.example.demo.service.mapper;

import com.example.demo.persistance.entities.User;
import com.example.demo.service.model.UserDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    List<User> toEntity(List<UserDto> userDtos);

    List<UserDto> toDto(List<User> Users);

}
