package com.alexandr.onlinestore.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private String userLogin;
    private String userPassword;
    private Long userId;
}
