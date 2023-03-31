package com.pepeni.springboot.cpudiff.repository;

import com.pepeni.springboot.cpudiff.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
}
