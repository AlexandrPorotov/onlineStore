package com.alexandr.onlinestore.repository;

import com.alexandr.onlinestore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.userLogin=?1")
    User getUserByUserLogin (String userLogin);

}

