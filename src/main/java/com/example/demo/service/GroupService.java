package com.example.demo.service;

import com.example.demo.persistance.entities.Group;
import com.example.demo.service.model.GroupDto;

import java.util.List;

public interface GroupService {

    GroupDto save(GroupDto groupDto);

    Group getGroup(Long id);

    List<GroupDto> getGroups();
}
