package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.ManageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ManageUserJpaRepository extends JpaRepository<ManageUser,Long>{

    @Query("select mu from ManageUser mu where mu.isDeleted = 'n' and mu.username = :username and mu.password = :password")
    ManageUser findByUsernameAndPwd(@Param("username") String username, @Param("password") String password);

    @Query("select mu from ManageUser mu where mu.isDeleted = 'n' and mu.username = :username")
    ManageUser findByUsername(@Param("username") String username);
}
