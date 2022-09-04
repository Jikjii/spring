package com.jikjii.springsecurityclient.service;

import com.jikjii.springsecurityclient.entity.User;
import com.jikjii.springsecurityclient.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);
}
