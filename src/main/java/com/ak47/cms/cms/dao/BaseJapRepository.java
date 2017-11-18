package com.ak47.cms.cms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
@NoRepositoryBean
public interface BaseJapRepository<T> extends JpaRepository<T,Long>{
    @Query("select e from #{#entityName} e where e.status = :status and e.isDeleted = 'n'")
    List<T> findCmsPage(@Param("status") Integer status);
}
