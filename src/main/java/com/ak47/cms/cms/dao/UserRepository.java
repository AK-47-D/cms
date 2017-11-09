package com.ak47.cms.cms.dao;


import com.ak47.cms.cms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User getUserByUserName(String userName);
}
