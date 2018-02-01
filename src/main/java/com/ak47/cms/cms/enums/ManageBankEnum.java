package com.ak47.cms.cms.enums;

public enum ManageBankEnum {
    FED(0,"联邦储备局","Fed"),
    ECB(1,"欧洲央行","ECB"),
    BOE(2,"英国央行","BoE"),
    BOJ(3,"日本央行","BoJ"),
    RBA(4,"澳洲联储","RBA"),
    BOC(5,"中国银行","BOC"),
    RBNZ(6,"新西兰央行","RBNZ"),
    SNB(7,"瑞士央行","SNB"),
    PBOC(8,"中国人民银行","PBoC");

    private final int code;
    private final String detailCn;
    private final String detailEn;

    ManageBankEnum(int code, String detailCn, String detailEn) {
        this.code = code;
        this.detailCn = detailCn;
        this.detailEn = detailEn;
    }

    public int getCode() {
        return code;
    }

    public String getDetailCn() {
        return detailCn;
    }

    public String getDetailEn() {
        return detailEn;
    }
}
