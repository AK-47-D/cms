package com.ak47.cms.cms.enums;

public enum ManageCountryEnum {
    FR(0,"美联储","FederalReserve"),
    ECB(1,"欧洲","Euro"),
    BOE(2,"英国","UK"),
    BOJ(3,"日本","Japan"),
    RBA(4,"澳大利亚","Australia"),
    RZBN(5,"新西兰","NewZealand"),
    SNB(6,"瑞士","Switzerland"),
    BOC(7,"加拿大","Canada"),
    CN(8,"中国","China"),
    USA(9,"美国","USA");

    private final int code;
    private final String detail;
    private final String detailEn;

    ManageCountryEnum(int code, String detail, String detailEn) {
        this.code = code;
        this.detail = detail;
        this.detailEn = detailEn;
    }

    public int getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }

    public String getDetailEn() {
        return detailEn;
    }
}
