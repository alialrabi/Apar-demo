package com.example.demo.service.impl;

import com.example.demo.persistance.entities.Group;
import com.example.demo.persistance.entities.User;
import com.example.demo.persistance.entities.UserGroup;
import com.example.demo.persistance.repos.GroupRepository;
import com.example.demo.persistance.repos.UserGroupRepository;
import com.example.demo.persistance.repos.UserRepository;
import com.example.demo.rest.request.UserRequest;
import com.example.demo.service.GroupService;
import com.example.demo.service.UserService;
import com.example.demo.service.mapper.GroupMapper;
import com.example.demo.service.mapper.UserMapper;
import com.example.demo.service.model.GroupDto;
import com.example.demo.service.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final GroupService groupService;

    private final UserMapper userMapper;

    private final GroupMapper groupMapper;

    private final UserGroupRepository groupRepository;

    public UserServiceImpl(UserRepository userRepository, GroupService groupService, UserMapper userMapper, GroupMapper groupMapper, UserGroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupService = groupService;
        this.userMapper = userMapper;
        this.groupMapper = groupMapper;
        this.groupRepository = groupRepository;
    }

    @Override
    public void save(UserRequest request) {
        User user = userRepository.save(buildUser(request));
        Group group = groupService.getGroup(request.getGroupId());

        UserGroup userGroup=new UserGroup();
        userGroup.setUser(user);
        userGroup.setGroup(group);

        groupRepository.save(userGroup);
    }

    @Override
    public UserDto getUser(Long id) {
        return userRepository.findById(id).map(userMapper::toDto)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toDto)
                .collect(Collectors.toList());
    }

   User buildUser(UserRequest request){
        User user=new User();
        user.setUsername(request.getEmail());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

        return user;
   }
}
