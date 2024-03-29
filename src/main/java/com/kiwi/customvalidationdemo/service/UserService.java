package com.kiwi.customvalidationdemo.service;

import com.kiwi.customvalidationdemo.dto.UserRequest;
import com.kiwi.customvalidationdemo.entity.User;
import com.kiwi.customvalidationdemo.exception.UserNotFoundException;
import com.kiwi.customvalidationdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(UserRequest userRequest) {
        User user = User.build(0, userRequest.getName(), userRequest.getEmail(),
                userRequest.getMobile(), userRequest.getGender(),
                userRequest.getAge(), userRequest.getNationality());//this is Lombok feature to populate fields
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) throws UserNotFoundException {
        User user = userRepository.findByUserId(id);
        if(user != null) {
            return user;
        } else {
            throw new UserNotFoundException("User not found with id " + id);
        }
    }
}
