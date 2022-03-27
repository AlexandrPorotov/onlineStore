package com.alexandr.onlinestore.service.userService;

import com.alexandr.onlinestore.model.User;
import com.alexandr.onlinestore.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    /*
    * покупка заказа (order)
    * добавление товаров в корзину
    * просмотр истории заказов
    * оплата заказа
    */
    private final UserRepository userRepository;

    public Optional<User> getByLogin(@NotNull String login){
        return Optional.ofNullable(userRepository.getUserByUserLogin(login));
    }

    public User findByLogin(@NotNull String login) {
        return userRepository.getUserByUserLogin(login);
    }

}
