package com.lcwd.user.service.repository;

import com.lcwd.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}
