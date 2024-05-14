package com.example.demo.rest;

import com.example.demo.rest.request.UserRequest;
import com.example.demo.rest.response.Response;
import com.example.demo.service.UserService;
import com.example.demo.service.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

     private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value="user")
    public ResponseEntity<Response> createUser(@RequestBody UserRequest userRequest){
        userService.save(userRequest);
        Response response = new Response("User saved successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "user/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id){
        UserDto userDto = userService.getUser(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping(value = "users")
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> userDto = userService.getUsers();
        return ResponseEntity.ok(userDto);
    }

}
