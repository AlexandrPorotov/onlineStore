package com.alexandr.onlinestore.service.adminService;

import com.alexandr.onlinestore.DTO.ResponseDTO;
import com.alexandr.onlinestore.model.Role;
import com.alexandr.onlinestore.model.User;
import com.alexandr.onlinestore.repository.UserRepository;
import com.alexandr.onlinestore.security.JwtAuthentication;
import com.alexandr.onlinestore.security.JwtProvider;
import com.alexandr.onlinestore.service.userService.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtProvider jwtProvider;
    private String response;

    public ResponseDTO addUser(HttpServletRequest httpServletRequest, String login, String password) {
        final String bearer = httpServletRequest.getHeader("Authorization").substring(7);
        User userFromDB = userService.findByLogin(login);
        if(jwtProvider.validateAccessToken(bearer) && userFromDB == null) {
            User user = new User();
            user.setUserLogin(login);
            user.setUserPassword(password);
            userRepository.save(user);
            response = "User add. Login - " + user.getUserLogin() + " {id} - " + user.getUserId();
        } else if (jwtProvider.validateAccessToken(bearer)){
            response = "This user already exist.";
        }
        return new ResponseDTO(response);
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
