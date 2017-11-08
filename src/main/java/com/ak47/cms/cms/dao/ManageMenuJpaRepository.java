package com.ak47.cms.cms.dao;

import com.ak47.cms.cms.dto.ManageMenuDto;
import com.ak47.cms.cms.entity.DataStatistics;
import com.ak47.cms.cms.entity.ManageMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface ManageMenuJpaRepository extends JpaRepository<ManageMenu,Long>{
    @Query("select new com.ak47.cms.cms.dto.ManageMenuDto(mm.id,mm.name,mm.gmtCreate,mm.gmtModified,mm.isDeleted,mm.parentId,mm.order,mm.url,umr.userId) from ManageMenu mm,UserMenuRelated umr where mm.id = umr.menuId and umr.isDeleted ='n' and mm.isDeleted ='n' and umr.userId =:userId and mm.parentId = 0 order by mm.order")
    List<ManageMenuDto> findUserMenu(@Param("userId") Long userId);
    @Query("select mm from ManageMenu mm,UserMenuRelated umr where mm.id = umr.menuId and mm.isDeleted ='n' and mm.parentId =:parentId and umr.isDeleted='n' and umr.userId=:userId order by mm.order")
    List<ManageMenu> findChildMenu(@Param("userId") Long userId,@Param("parentId") Long parentId);
}
