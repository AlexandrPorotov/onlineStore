package com.alexandr.onlinestore.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*Ответ на запрос пользователя, отправляет токен*/
@Getter
@AllArgsConstructor
public class JwtResponse {

    private final String type = "Bearer";
    private String accessToken;
    private String refreshToken;
}
