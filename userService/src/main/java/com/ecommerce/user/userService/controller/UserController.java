package com.ecommerce.user.userService.controller;

import com.ecommerce.user.userService.Models.AuthRequest;
import com.ecommerce.user.userService.Models.AuthResponse;
import com.ecommerce.user.userService.Models.Response;
import com.ecommerce.user.userService.service.UserService;
import com.ecommerce.user.userService.entity.User;
import com.ecommerce.user.userService.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtUtil.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/register")
    public ResponseEntity<Response> registerUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/validate")
    public String getUserByUsername(@RequestParam("token") String token, @RequestBody AuthRequest authRequest) {
        return jwtUtil.validateToken(token, authRequest) ? "Token is Valid" : "Token is inValid";
    }

    @GetMapping
    public String getUserByUsernames() {
        return "username";
    }
}
