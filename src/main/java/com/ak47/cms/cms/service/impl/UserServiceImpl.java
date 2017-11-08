package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.UserRepository;
import com.ak47.cms.cms.entity.User;
import com.ak47.cms.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }
}
