package com.alexandr.onlinestore.controller.adminController;

import com.alexandr.onlinestore.DTO.RoleDTO;
import com.alexandr.onlinestore.DTO.UserDTO;
import com.alexandr.onlinestore.service.adminService.AdminService;
import com.alexandr.onlinestore.service.authService.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final AuthService authService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("create-new-user")
    public String addUser(HttpServletRequest httpServletRequest, @RequestBody UserDTO userInfo){
        return adminService.addUser(httpServletRequest, userInfo.getUserLogin(),userInfo.getUserPassword()).getBody();
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("set-role/users/{userId}")
    public void setRole(@RequestBody RoleDTO roleInfo){
        adminService.setRole(roleInfo.getRole(),roleInfo.getUserId());
    }
}
