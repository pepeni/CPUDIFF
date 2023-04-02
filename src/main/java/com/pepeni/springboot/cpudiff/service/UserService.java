package com.pepeni.springboot.cpudiff.service;

import com.pepeni.springboot.cpudiff.exception.ProcessorNotFoundException;
import com.pepeni.springboot.cpudiff.exception.UserNotFoundException;
import com.pepeni.springboot.cpudiff.model.Processor;
import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User addUser(User user){
        return userRepo.save(user);
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User findUserById(Long id){
        return userRepo.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id = " + id + " was not found"));
    }

    public void findUserByNick(String nick){
        userRepo.findUserByNick(nick).orElseThrow(() -> new UserNotFoundException("User by nick = " + nick + " was not found"));
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }
}
