package com.ecommerce.user.userService.service;


import com.ecommerce.user.userService.entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);
    Optional<User> getUserByUsername(String username);
}