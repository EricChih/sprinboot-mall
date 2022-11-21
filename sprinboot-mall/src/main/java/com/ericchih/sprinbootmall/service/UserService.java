package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dto.UserRegisterRequest;
import com.ericchih.sprinbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);


}
