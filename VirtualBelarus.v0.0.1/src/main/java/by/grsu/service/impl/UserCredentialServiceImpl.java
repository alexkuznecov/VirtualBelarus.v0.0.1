package by.grsu.service.impl;

import by.grsu.domain.UserCredential;
import by.grsu.service.UserCredentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userCredentialServiceImpl")
public class UserCredentialServiceImpl {

    @Autowired
    private UserCredentialService userCredentialService;

    public UserCredential getRegisteredUserCredential(String login, String password) {
        return userCredentialService.getRegisteredUserCredential(login,password);
    }
}
