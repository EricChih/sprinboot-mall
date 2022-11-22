package com.ericchih.sprinbootmall.service.Impl;

import com.ericchih.sprinbootmall.dao.UserDao;
import com.ericchih.sprinbootmall.dto.UserLoginRequest;
import com.ericchih.sprinbootmall.dto.UserRegisterRequest;
import com.ericchih.sprinbootmall.model.User;
import com.ericchih.sprinbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;


    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user= userDao.getUserByEmail(userRegisterRequest.getEmail());

        //檢查註冊的 email
        if (user != null){
            log.warn("該 email {} 已經被註冊",userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        //創建帳號
        return userDao.createUser(userRegisterRequest);
    }

    @Override
    public User login(UserLoginRequest userLoginRequest) {
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if(user == null){
            log.warn("該email尚未註冊",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(user != userDao.getUserByEmail(userLoginRequest.getEmail())){
          log.warn("信箱輸入錯誤");
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        //比較String的值要用equal來比較
        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        }else{
            log.warn("email{}的密碼不正確",userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }

    }
}
