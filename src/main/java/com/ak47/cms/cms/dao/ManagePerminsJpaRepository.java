package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.ManagePermins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ManagePerminsJpaRepository extends JpaRepository<ManagePermins,Long>{
    @Query("select mp from ManageUser mu,ManagePermins mp,ManageUserPerminsRelated mupr where mu.id = mupr.userId and mp.id = mupr.perminsId and mu.isDeleted = 'n' and mp.isDeleted = 'n' and mupr.isDeleted = 'n' and mu.id = :userId")
    List<ManagePermins> findByUserId(@Param("userId") Long userId);
}
