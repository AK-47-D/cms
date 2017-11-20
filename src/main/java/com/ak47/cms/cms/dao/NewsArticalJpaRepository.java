package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.NewsArtical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface NewsArticalJpaRepository extends JpaRepository<NewsArtical,Long>{
    @Query("select n from NewsArtical n where n.url = :url")
    List<NewsArtical> findByUrl(@Param("url") String url);
    @Query("select n from NewsArtical n where n.happenDate < :happenDate and status =:status")
    Page<NewsArtical> findByFocus(@Param("happenDate") Date happenDate, @Param("status") Integer status,Pageable pageable);
}
