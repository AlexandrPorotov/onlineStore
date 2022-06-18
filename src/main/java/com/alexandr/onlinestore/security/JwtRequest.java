package com.alexandr.onlinestore.security;

import lombok.Data;

/* Запрос пользователя на выдачу токенов*/

@Data
public class JwtRequest {

    private String userLoginJwtRequest;
    private String userPasswordJwtRequest;

}
