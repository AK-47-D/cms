package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.NewsArtical;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@NoRepositoryBean
public interface BaseJapRepository<T> extends JpaRepository<T,Long>{
    @Query("select e from #{#entityName} e where e.status = :status and e.isDeleted = 'n'")
    List<T> findCmsPage(@Param("status") Integer status);
    @Query("select e from #{#entityName} e where e.status = :status and e.isDeleted = 'n'")
    Page<T> findCmsPage(@Param("status") Integer status, Pageable pageable);
}
