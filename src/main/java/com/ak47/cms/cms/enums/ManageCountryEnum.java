package com.ak47.cms.cms.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ManageCountryEnum {
    FR(0,"美联储"),
    ECB(1,"欧洲"),
    BOE(2,"英国"),
    BOJ(3,"日本"),
    RBA(4,"澳大利亚"),
    RZBN(5,"新西兰"),
    SNB(6,"瑞士"),
    BOC(7,"加拿大");

    private int code;
    private String detail;

    ManageCountryEnum(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
