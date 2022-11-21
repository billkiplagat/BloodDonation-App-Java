package com.billy.controllers;

import com.billy.user.NewUserRegistrationRequest;
import com.billy.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/registerDonor")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody NewUserRegistrationRequest registrationRequest) {
        userService.registerUser(registrationRequest);
    }

    @PostMapping("/registerAdmin")
//    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAdmin(@RequestBody NewUserRegistrationRequest registrationRequest) {
        userService.registerAdmin(registrationRequest);
    }

//
//    @GetMapping("/{userId}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public UserProfileResponse getUserDetailsById(@PathVariable Long userId) {
//        return userService.getUserById(userId);
//    }
}
