package com.ak47.cms.cms.service;

import com.ak47.cms.cms.entity.User;

public interface UserService {
    void saveUser(User user);

    boolean doLogin(User user);
}
