package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.dto.UserRegisterRequest;
import com.ericchih.sprinbootmall.model.User;

public interface UserDao {

    User getUserById(Integer userId);

    Integer createUser(UserRegisterRequest userRegisterRequest);


}
