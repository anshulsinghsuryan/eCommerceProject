package com.ecommerce.user.userService.service;


import com.ecommerce.user.userService.Models.Response;
import com.ecommerce.user.userService.entity.User;
import com.ecommerce.user.userService.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtService jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public Response createUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User users =  userRepository.save(user);
        final String token = jwtUtil.generateToken(user.getUsername());
        return new Response(users, token);
    }

}