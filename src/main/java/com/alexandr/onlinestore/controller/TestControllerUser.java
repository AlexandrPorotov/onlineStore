package com.alexandr.onlinestore.controller;

import com.alexandr.onlinestore.DTO.RoleDTO;
import com.alexandr.onlinestore.DTO.UserDTO;
import com.alexandr.onlinestore.service.userService.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test/user")
@AllArgsConstructor
public class TestControllerUser {

    private final UserService userService;

    @PostMapping("add")
    public void addUser(@RequestBody UserDTO userInfo){
        userService.addUser(userInfo.getUserLogin(),userInfo.getUserPassword());
    }

    @PostMapping("set/role")
    public void setRole(@RequestBody RoleDTO roleInfo){
        userService.setRole(roleInfo.getRole(),roleInfo.getUserId());
    }
}
