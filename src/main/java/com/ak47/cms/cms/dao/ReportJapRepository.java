package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.entity.Report;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ReportJapRepository extends BaseJapRepository<Report>{

    @Query("select max(r.happenDate),min(r.happenDate) from Report r ")
    Map<String,Object> findAroundDate();
}
