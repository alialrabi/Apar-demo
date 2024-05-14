package com.example.demo.service.impl;

import com.example.demo.persistance.entities.Group;
import com.example.demo.persistance.repos.GroupRepository;
import com.example.demo.service.GroupService;
import com.example.demo.service.mapper.GroupMapper;
import com.example.demo.service.model.GroupDto;
import com.example.demo.service.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;

    private final GroupMapper groupMapper;

    public GroupServiceImpl(GroupRepository groupRepository, GroupMapper groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public GroupDto save(GroupDto groupDto) {
        return null;
    }

    @Override
    public Group getGroup(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Group not found"));
    }

    @Override
    public List<GroupDto> getGroups() {
        return null;
    }
}
