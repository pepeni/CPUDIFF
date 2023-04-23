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

import java.util.Objects;
import java.util.Optional;

@RestController
@Service
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody loginRequest request){
        User user;
        if (userService.findUserByEmail(request.login()) != null) {
            user = userService.findUserByEmail(request.login());
        }
        else if (userService.findUserByNick(request.login())!=null) {
            user = userService.findUserByNick(request.login());
        }
        else {
            return new ResponseEntity<>("This nickname is used by existing account", HttpStatus.BAD_REQUEST);
        }

        if(!(Objects.equals(user.getPassword(), request.password()))){
            return new ResponseEntity<>("Password is incorrect", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User loged in successfully", HttpStatus.OK);
    }

    private record loginRequest(

            @NotNull(message = "Please enter valid login")
            @NotBlank(message = "Please enter valid login")
            @Size(min = 3, max = 64, message = "Please enter valid login 3 - 50 characters")
            String login,

            @NotNull(message = "Please enter valid password")
            @NotBlank(message = "Please enter valid password")
            @Pattern(regexp = "^.{5,64}$", message =
                    "Please enter valid password 5-64 characters")
            String password) {
    }

}
