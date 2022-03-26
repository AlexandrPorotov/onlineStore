package com.alexandr.onlinestore.service.userService;

import com.alexandr.onlinestore.model.Role;
import com.alexandr.onlinestore.model.User;
import com.alexandr.onlinestore.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
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

    public void addUser(String login, String password) {
        User user = new User();
        user.setUserLogin(login);
        user.setUserPassword(password);
        userRepository.save(user);
    }
    public void setRole(String role, Long userId) {
        User userFromDB = userRepository.getById(userId);
        if(role.equalsIgnoreCase("user")){
            userFromDB.setUserRole(Role.USER);
        } else {
            userFromDB.setUserRole(Role.ADMIN);
        }
        userRepository.save(userFromDB);
    }

}
