package com.example.demo.service.mapper;

import com.example.demo.persistance.entities.Group;
import com.example.demo.service.model.GroupDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper{

    Group toEntity(GroupDto groupDto);

    GroupDto toDto(Group group);
}
