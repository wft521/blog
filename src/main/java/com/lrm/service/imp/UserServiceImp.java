package com.lrm.service.imp;

import com.lrm.dao.UserRepository;
import com.lrm.po.User;
import com.lrm.service.UserService;
import com.lrm.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wu
 * @date 2022-01-17 13:57
 */
@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username,String password){
        User user=userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }



}
