package com.lcwd.user.service.services.imp;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImp implements UserService {
    Logger logger= LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    @Override
    @CachePut(cacheNames = "cacheStore", key="#user.name")
    public User saveUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "cacheStore", key = "#name")
    public User getUser(String name) {
        logger.info("Request coming in service layer for fetching User by ID: {}",name);
        return userRepository.findByName(name);
     //   return userRepository.findByName(name).orElseThrow(()->new ResourceNotFoundException("User is not find in our record with id "+ name));
    }
}
