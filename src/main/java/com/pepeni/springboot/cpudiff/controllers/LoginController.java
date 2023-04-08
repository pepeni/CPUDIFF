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
        else if (userService.findUserByNick(request.login()).isPresent()) {
            user = userService.findUserByNick(request.login());
        }
        else {
            return new ResponseEntity<>("This nickname is used by existing account", HttpStatus.BAD_REQUEST);
        }

        if(user.)

        return new ResponseEntity<>("User loged in successfully", HttpStatus.OK);
    }

    private record loginRequest(

            @NotBlank(message = "1")
            @NotNull(message = "0")
            @Size(min = 3, max = 64, message = "2")
            String login,

            @NotNull(message = "0")
            @NotBlank(message = "1")
            @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–\\[\\]{}:;',?/*~$^+=<>]).{8,64}$", message =
                    "4")
            String password) {
    }

}
