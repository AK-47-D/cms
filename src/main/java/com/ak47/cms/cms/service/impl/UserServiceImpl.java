package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.common.MD5Util;
import com.ak47.cms.cms.dao.UserRepository;
import com.ak47.cms.cms.entity.User;
import com.ak47.cms.cms.service.UserService;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public void saveUser(User user) {
        Date now = new Date();
        user.setGmtCreate(now);
        user.setGmtModified(now);
        user.setIsDelete("N");
        user.setPassword(MD5Util.md5(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public boolean doLogin(User loginUser) {
        loginUser.setPassword(MD5Util.md5(loginUser.getPassword()));
        if( userRepository.getUserByLoginUser(loginUser.getUserName(),loginUser.getPassword()) == null) return false;
        return true;
    }


}
