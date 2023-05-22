package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findUserByUsernameAndPassword(String username, String password) {
        return userRepository.findUserByUsernameAndPassword(username, password);
    }

    public User findById(int id)
    {
        return userRepository.findById(id);
    }

    public boolean setNewPassword(int id, String new_password)
    {
        User user = userRepository.findById(id);

        if (user != null) {
            // modify the desired variable of the entity object
            user.setPassword(new_password);

            // save the changes to the database
            userRepository.save(user);
            return true;
        }
        else return false;
    }
}
