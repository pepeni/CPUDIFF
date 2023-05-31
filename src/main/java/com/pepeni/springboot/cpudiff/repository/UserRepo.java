package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "DELETE FROM USERS WHERE id= :userId", nativeQuery = true)
    void deleteUserById(@Param("userId")Long id);

    User findUserById(Long id);

    @Query(value = "SELECT * FROM USERS WHERE nick= :myNick", nativeQuery = true)
    User findUserByNick(@Param("myNick") String nick);

    @Query(value = "SELECT * FROM USERS WHERE email= :myEmail", nativeQuery = true)
    User findUserByEmail(@Param("myEmail") String email);

    Optional<User> findByEmail(String email);
}
