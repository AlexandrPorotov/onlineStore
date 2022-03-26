package com.alexandr.onlinestore.security;

import lombok.AllArgsConstructor;

/*Ответ на запрос пользователя, отправляет токен*/
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
