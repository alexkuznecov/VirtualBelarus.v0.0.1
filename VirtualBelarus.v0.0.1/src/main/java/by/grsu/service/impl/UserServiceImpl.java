package by.grsu.service.impl;

import by.grsu.domain.User;
import by.grsu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl {

    @Autowired
    UserService userService;

    public User getUserByLogin(String login) {
        return userService.getUserByLogin(login);
    }
}
