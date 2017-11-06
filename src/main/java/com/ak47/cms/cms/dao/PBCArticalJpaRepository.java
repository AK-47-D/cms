package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.PBCArtical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface PBCArticalJpaRepository extends JpaRepository<PBCArtical,Long>{
    @Query("select n from PBCArtical n where n.url = :url")
    List<PBCArtical> findByUrl(@Param("url") String url);
}
