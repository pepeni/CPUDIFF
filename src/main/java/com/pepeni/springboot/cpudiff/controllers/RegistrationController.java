package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.service.UserService;
import jakarta.validation.constraints.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {

        if (userService.findUserByEmail(request.email()) != null) {
            return new ResponseEntity<>("This email is used by existing account", HttpStatus.BAD_REQUEST);
        }

        if (userService.findUserByNick(request.nickname())!=null) {
            return new ResponseEntity<>("This nickname is used by existing account", HttpStatus.BAD_REQUEST);
        }

        userService.addUser(new User(request.nickname(), request.email(), request.password()));
        User user = userService.findUserByEmail(request.email());

        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    private record RegistrationRequest(
            @NotNull(message = "Please enter valid nickname")
            @NotBlank(message = "Please enter valid nickname")
            @Size(min = 3, max = 50, message = "Please enter valid nickname 3 - 50 characters")
            String nickname,

            @Email(message = "Please enter valid email")
            @Pattern(regexp = ".+@.+\\..+", message = "Please enter valid email")
            @NotBlank(message = "Please enter valid email")
            @NotNull(message = "Please enter valid email")
            @Size(min = 3, max = 64, message = "Please enter valid email")
            String email,

            @NotNull(message = "Please enter valid password")
            @NotBlank(message = "Please enter valid password")
            @Pattern(regexp = "^.{5,64}$", message =
                    "Please enter valid password 5-64 characters")
            String password) {
    }

}
