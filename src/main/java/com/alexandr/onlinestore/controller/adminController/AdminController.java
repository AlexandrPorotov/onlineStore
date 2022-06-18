package com.alexandr.onlinestore.controller.adminController;

import com.alexandr.onlinestore.DTO.ResponseDTO;
import com.alexandr.onlinestore.DTO.RoleDTO;
import com.alexandr.onlinestore.DTO.UserDTO;
import com.alexandr.onlinestore.service.adminService.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/admin")
@AllArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("create-new-user")
    public ResponseEntity<ResponseDTO> addUser(HttpServletRequest httpServletRequest, @RequestBody UserDTO userInfo){
        final ResponseDTO responseDTO = adminService.addUser(httpServletRequest, userInfo.getUserLogin(),userInfo.getUserPassword());
        return ResponseEntity.ok(responseDTO);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("set-role")
    public ResponseEntity<ResponseDTO> setRole(@RequestBody RoleDTO roleInfo){
        ResponseDTO responseDTO = adminService.setRole(roleInfo.getRole(),roleInfo.getUserId());
        return ResponseEntity.ok(responseDTO);
    }

    @PreAuthorize(("hasAuthority('ADMIN')"))
    @GetMapping(value = "users/role/", params = {"user_id"})
    public ResponseEntity<ResponseDTO> getUserRoleById(@RequestParam(value = "user_id") Long userId){
        ResponseDTO responseDTO = adminService.getUserRoleById(userId);
        return ResponseEntity.ok(responseDTO);
    }
}
