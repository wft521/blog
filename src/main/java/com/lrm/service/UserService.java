package com.lrm.service;

import com.lrm.po.User;
import org.springframework.stereotype.Service;

/**
 * @author wu
 * @date 2022-01-17 12:42
 */

public interface UserService {
    User checkUser(String username, String password);
}
