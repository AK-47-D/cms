package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.PBCArtical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface DataStatisticJpaRepository extends JpaRepository<DataStatistics,Long>{
    @Query("select d from DataStatistics d where d.url3 = :url")
    List<DataStatistics> findByUrl(@Param("url") String url);
}
