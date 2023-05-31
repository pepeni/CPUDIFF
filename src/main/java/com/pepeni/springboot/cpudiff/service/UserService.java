package com.pepeni.springboot.cpudiff.service;

import com.pepeni.springboot.cpudiff.model.User;
import com.pepeni.springboot.cpudiff.repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return userRepo.findUserById(id);
    }

    public User findUserByNick(String nick){
        return userRepo.findUserByNick(nick);
    }

    public User findUserByEmail(String email){return userRepo.findUserByEmail(email);}

    @Transactional
    public void deleteUser(Long id){userRepo.deleteUserById(id);}

    public Optional<User> findByEmail(String email) {return userRepo.findByEmail(email);}
}
