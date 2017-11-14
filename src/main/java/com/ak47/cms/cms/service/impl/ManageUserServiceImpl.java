package com.ak47.cms.cms.service.impl;

import com.ak47.cms.cms.dao.ManageUserJpaRepository;
import com.ak47.cms.cms.dto.ManageUserDto;
import com.ak47.cms.cms.entity.ManageUser;
import com.ak47.cms.cms.result.Result;
import com.ak47.cms.cms.result.ResultUtils;
import com.ak47.cms.cms.service.BaseService;
import com.ak47.cms.cms.service.ManageUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageUserServiceImpl implements ManageUserService {
    @Autowired
    private ManageUserJpaRepository manageUserJpaRepository;
    @Override
    public ManageUser save(ManageUser manageUser) {
        return manageUserJpaRepository.save(manageUser);
    }

    @Override
    public List<ManageUser> findAll() {
        return manageUserJpaRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        manageUserJpaRepository.deleteById(id);
    }

    @Override
    public ManageUser findOne(Long id) {
        return manageUserJpaRepository.getOne(id);
    }

    @Override
    public Result<ManageUserDto> findByUser(String username, String password) {
        ManageUser manageUser  = findByUsername(username);
        if(manageUser == null){
            return ResultUtils.instanceResult("帐号不存在",null,false,"登录失败");
        }
        String md5Pwd = new Md5Hash(password, manageUser.getSalt()).toString();
        manageUser  = findByUsernameAndPwd(username,md5Pwd);
        if(manageUser == null){
            return ResultUtils.instanceResult("密码错误",null,false,"登录失败");
        }
        return ResultUtils.instanceResult("登录成功",new ManageUserDto(manageUser),true,"登录提示");
    }

    @Override
    public ManageUser findByUsername(String username) {
        return manageUserJpaRepository.findByUsername(username);
    }

    @Override
    public ManageUser findByUsernameAndPwd(String username, String password) {
        return manageUserJpaRepository.findByUsernameAndPwd(username,password);
    }
}
