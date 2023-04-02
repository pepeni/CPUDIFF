package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findUserById(Long id);

    @Query("SELECT u FROM USERS u WHERE nick=?1")
    Optional<User> findUserByNick(String nick);
}
