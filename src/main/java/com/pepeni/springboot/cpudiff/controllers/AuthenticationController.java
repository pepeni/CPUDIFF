package com.pepeni.springboot.cpudiff.controllers;

import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.requestResponse.AuthenticationRequest;
import com.pepeni.springboot.cpudiff.requestResponse.AuthenticationResponse;
import com.pepeni.springboot.cpudiff.requestResponse.RegisterRequest;
import com.pepeni.springboot.cpudiff.service.AuthenticationService;
import com.pepeni.springboot.cpudiff.service.CommentService;
import com.pepeni.springboot.cpudiff.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserService userService;
    private final CommentService commentService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @DeleteMapping("/deleteAccount")
    public ResponseEntity<?> deleteAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        System.out.println(user.getId());
        commentService.deleteCommentsByUserId(user.getId());
        userService.deleteUser(user.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
