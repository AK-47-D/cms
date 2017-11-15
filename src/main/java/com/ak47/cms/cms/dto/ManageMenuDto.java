package com.ak47.cms.cms.dto;

import com.ak47.cms.cms.entity.ManageMenu;

import java.util.Date;
import java.util.List;

public class ManageMenuDto extends ManageMenu {
    private Long userId;
    private List<ManageMenu> childMenu;

    public List<ManageMenu> getChildMenu() {
        return childMenu;
    }

    public void setChildMenu(List<ManageMenu> childMenu) {
        this.childMenu = childMenu;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public ManageMenuDto(){

    }
    public ManageMenuDto(Long id, String name, Date gmtCreate,Date gmtModified,String isDeleted,Long parentId,Integer menuOrder,String url,Long userId) {
        setId(id);
        setName(name);
        setGmtCreate(gmtCreate);
        setGmtModified(gmtModified);
        setIsDeleted(isDeleted);
        setParentId(parentId);
        setMenuOrder(menuOrder);
        setUrl(url);
        this.userId = userId;
    }
}
