package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.ManageRole;
import com.ak47.cms.cms.entity.ManageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ManageRoleJpaRepository extends JpaRepository<ManageRole,Long>{
    @Query("select mr from ManageUser mu,ManageRole mr,ManageUserRoleRelated murr where mu.id = murr.userId and mr.id = murr.roleId and mu.isDeleted = 'n' and mr.isDeleted = 'n' and murr.isDeleted = 'n' and mu.id = :userId")
    List<ManageRole> findByUserId(@Param("userId") Long userId);
}
