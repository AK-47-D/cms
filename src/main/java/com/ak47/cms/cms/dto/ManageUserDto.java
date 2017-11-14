package com.ak47.cms.cms.dto;

import com.ak47.cms.cms.entity.ManagePermins;
import com.ak47.cms.cms.entity.ManageRole;
import com.ak47.cms.cms.entity.ManageUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class ManageUserDto extends ManageUser {
    public ManageUserDto(){

    }
    public ManageUserDto(ManageUser manageUser){
        setGmtCreate(manageUser.getGmtCreate());
        setGmtModified(manageUser.getGmtModified());
        setId(manageUser.getId());
        setIsDeleted(manageUser.getIsDeleted());
        setPassword(manageUser.getPassword());
        setSalt(manageUser.getSalt());
        setSign(manageUser.getSign());
        setUsername(manageUser.getUsername());
        setName(manageUser.getName());
    }
    private List<ManagePermins> managePerminsList;
    private List<ManageRole> manageRoleList;

    public List<ManagePermins> getManagePerminsList() {
        return managePerminsList;
    }

    public void setManagePerminsList(List<ManagePermins> managePerminsList) {
        this.managePerminsList = managePerminsList;
    }

    public List<ManageRole> getManageRoleList() {
        return manageRoleList;
    }

    public void setManageRoleList(List<ManageRole> manageRoleList) {
        this.manageRoleList = manageRoleList;
    }
}
