package com.jikjii.springsecurityclient.controller;

import com.jikjii.springsecurityclient.entity.User;
import com.jikjii.springsecurityclient.event.RegistrationCompleteEvent;
import com.jikjii.springsecurityclient.model.UserModel;
import com.jikjii.springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    // REGISTER USER METHOD
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                "url"
        ));
        return "Success";
    }
}
