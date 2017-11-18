package com.ak47.cms.cms.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class FocusEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long country;
    private Date gmtCreate;
    private Date gmtModified;
    private Date happenDate;
    private String isDeleted;
    private Integer status;
    private Integer source;
    private Double gdp;
    private Double cpi;
    private Double nu;
    private Integer level;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public void setCpi(Double cpi) {
        this.cpi = cpi;
    }

    public void setNu(Double nu) {
        this.nu = nu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getCountry() {
        return country;
    }

    public void setCountry(Long country) {
        this.country = country;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Date getHappenDate() {
        return happenDate;
    }

    public void setHappenDate(Date happenDate) {
        this.happenDate = happenDate;
    }


    public Double getGdp() {
        return gdp;
    }

    public Double getCpi() {
        return cpi;
    }

    public Double getNu() {
        return nu;
    }
}
