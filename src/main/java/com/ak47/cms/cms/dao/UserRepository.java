package com.ak47.cms.cms.dao;


import com.ak47.cms.cms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u  where u.userName= ?1 and u.password= ?2" )
    User getUserByLoginUser(String userName , String password);
}
