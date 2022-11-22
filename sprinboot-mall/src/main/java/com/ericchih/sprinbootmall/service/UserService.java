package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dto.UserLoginRequest;
import com.ericchih.sprinbootmall.dto.UserRegisterRequest;
import com.ericchih.sprinbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

    User login(UserLoginRequest userLoginRequest);
}
