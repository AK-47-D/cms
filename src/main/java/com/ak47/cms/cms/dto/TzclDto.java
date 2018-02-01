package com.ak47.cms.cms.dto;

import com.ak47.cms.cms.entity.Tzcl;
import com.ak47.cms.cms.enums.ManageBankEnum;
import com.ak47.cms.cms.enums.ManageCountryEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class TzclDto{
    private Long id;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtCreate;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gmtModified;
    private String isDeleted;
    private int country;
    private int bank;
    private BigDecimal gdpDiff;
    private BigDecimal cpiDiff;
    private BigDecimal unDiff;
    private BigDecimal rDiff;
    private String scenario;
    private String gdpStatus;
    private String cpiStatus;
    private String unStatus;
    private String rStatus;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date openDate;
    private BigDecimal gdp;
    private BigDecimal cpi;
    private BigDecimal un;
    private String r;
    private BigDecimal perGdp;
    private BigDecimal perCpi;
    private BigDecimal perUn;
    private String perR;

    public TzclDto(Tzcl tzcl) {
        bank = tzcl.getBank();
        country = tzcl.getCountry();
        cpi = tzcl.getCpi();
        gdp = tzcl.getGdp();
        gmtCreate = tzcl.getGmtCreate();
        gmtModified = tzcl.getGmtModified();
        id = tzcl.getId();
        isDeleted = tzcl.getIsDeleted();
        openDate = tzcl.getOpenDate();
        r = tzcl.getR();
        un = tzcl.getUn();
    }

    public TzclDto(Long id, Date gmtCreate, Date gmtModified, String isDeleted, Date openDate, int country, int bank, String r, BigDecimal gdp, BigDecimal cpi, BigDecimal un, String perR, BigDecimal  perGdp, BigDecimal perCpi, BigDecimal perUn) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.isDeleted = isDeleted;
        this.country = country;
        this.bank = bank;
        this.openDate = openDate;
        this.gdp = gdp;
        this.cpi = cpi;
        this.un = un;
        this.r = r;
        this.perGdp = perGdp;
        this.perCpi = perCpi;
        this.perUn = perUn;
        this.perR = perR;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getBank() {
        return bank;
    }

    public void setBank(int bank) {
        this.bank = bank;
    }

    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    public BigDecimal getGdp() {
        return gdp;
    }

    public void setGdp(BigDecimal gdp) {
        this.gdp = gdp;
    }

    public BigDecimal getCpi() {
        return cpi;
    }

    public void setCpi(BigDecimal cpi) {
        this.cpi = cpi;
    }

    public BigDecimal getUn() {
        return un;
    }

    public void setUn(BigDecimal un) {
        this.un = un;
    }

    public String getR() {
        return r;
    }

    public void setR(String r) {
        this.r = r;
    }

    public BigDecimal getPerGdp() {
        return perGdp;
    }

    public void setPerGdp(BigDecimal perGdp) {
        this.perGdp = perGdp;
    }

    public BigDecimal getPerCpi() {
        return perCpi;
    }

    public void setPerCpi(BigDecimal perCpi) {
        this.perCpi = perCpi;
    }

    public BigDecimal getPerUn() {
        return perUn;
    }

    public void setPerUn(BigDecimal perUn) {
        this.perUn = perUn;
    }

    public String getPerR() {
        return perR;
    }

    public void setPerR(String perR) {
        this.perR = perR;
    }

    public BigDecimal getGdpDiff() {
        return gdpDiff;
    }

    public void setGdpDiff(BigDecimal gdpDiff) {
        this.gdpDiff = gdpDiff;
    }

    public BigDecimal getCpiDiff() {
        return cpiDiff;
    }

    public void setCpiDiff(BigDecimal cpiDiff) {
        this.cpiDiff = cpiDiff;
    }

    public BigDecimal getUnDiff() {
        return unDiff;
    }

    public void setUnDiff(BigDecimal unDiff) {
        this.unDiff = unDiff;
    }

    public BigDecimal getrDiff() {
        return rDiff;
    }

    public void setrDiff(BigDecimal rDiff) {
        this.rDiff = rDiff;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public String getGdpStatus() {
        return gdpStatus;
    }

    public void setGdpStatus(String gdpStatus) {
        this.gdpStatus = gdpStatus;
    }

    public String getCpiStatus() {
        return cpiStatus;
    }

    public void setCpiStatus(String cpiStatus) {
        this.cpiStatus = cpiStatus;
    }

    public String getUnStatus() {
        return unStatus;
    }

    public void setUnStatus(String unStatus) {
        this.unStatus = unStatus;
    }

    public String getrStatus() {
        return rStatus;
    }

    public void setrStatus(String rStatus) {
        this.rStatus = rStatus;
    }
}
