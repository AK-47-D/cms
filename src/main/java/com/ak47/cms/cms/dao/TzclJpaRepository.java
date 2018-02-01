package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.dto.TzclDto;
import com.ak47.cms.cms.entity.Tzcl;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface TzclJpaRepository extends JpaRepository<Tzcl,Long>{
    @Query(value = "SELECT  " +
            "id,  " +
            "gmt_create gmt_create,  " +
            "gmt_modified gmt_modified,  " +
            "is_deleted is_deleted,  " +
            "open_date open_date,  " +
            "country,  " +
            "bank,  " +
            "CASE  " +
            "WHEN r = 0 THEN  " +
            "(SELECT  " +
            "ifnull(r,0)  " +
            "FROM  " +
            "tzcl t1  " +
            "WHERE  " +
            "t1.country = t.country  " +
            "AND t.bank = t1.bank and r != 0 and is_deleted = 'n' order by t1.open_date desc limit 1) else r end r,  " +
            "CASE  " +
            "WHEN gdp = 0 THEN  " +
            "(SELECT  " +
            "ifnull(gdp,0)  " +
            "FROM  " +
            "tzcl t1  " +
            "WHERE  " +
            "t1.country = t.country  " +
            "AND t.bank = t1.bank and gdp != 0 and is_deleted = 'n' order by t1.open_date desc limit 1) else gdp end gdp,  " +
            "CASE  " +
            "WHEN cpi = 0 THEN " +
            "(SELECT " +
            "ifnull(cpi,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and cpi != 0 and is_deleted = 'n' order by t1.open_date desc limit 1) else cpi end cpi, " +
            "CASE " +
            "WHEN un = 0 THEN " +
            "(SELECT " +
            "ifnull(un,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and un != 0 and is_deleted = 'n' order by t1.open_date desc limit 1) else un end un, " +
            "(SELECT " +
            "ifnull(r,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and r != 0 and is_deleted = 'n' order by t1.open_date desc limit 1,1) else r end per_r, " +
            "(SELECT " +
            "ifnull(gdp,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and gdp != 0 and is_deleted = 'n' order by t1.open_date desc limit 1,1) per_gdp, " +
            "(SELECT " +
            "ifnull(cpi,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and cpi != 0 and is_deleted = 'n' order by t1.open_date desc limit 1,1) per_cpi, " +
            "(SELECT " +
            "ifnull(un,0) " +
            "FROM " +
            "tzcl t1 " +
            "WHERE " +
            "t1.country = t.country " +
            "AND t.bank = t1.bank and un != 0 and is_deleted = 'n' order by t1.open_date desc limit 1,1)  per_un " +
            "FROM " +
            "tzcl t " +
            "WHERE " +
            "r != 0 and is_deleted = 'n' order by open_date desc limit :pageStart,:pageSize",nativeQuery = true)
    List<TzclDto> findTable(@Param("pageStart")int pageStart,@Param("pageSize")int pageSize);

    @Query("select count(t.id) from Tzcl t")
    int findTableCount();
    @Query(value="SELECT * FROM Tzcl WHERE country = :country AND bank = :bank and :type <> 0 and is_deleted = 'n' order by open_date desc limit 1,1",nativeQuery = true)
    Tzcl findPreTzcl(@Param("country")int country, @Param("bank")int bank, @Param("type")String type);
    @Query("select t from Tzcl t where t.r <> '' and t.r is not null and t.isDeleted = 'n' order by t.openDate desc")
    Page<Tzcl> findTzclTable(Pageable pageable);
}
