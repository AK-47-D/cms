package com.ak47.cms.cms.enums;

public enum ManageLevelEnum {
    LOW(0,"低"),
    MIDDLE(1,"中"),
    HIGH(2,"高");

    private int code;
    private String detail;

    ManageLevelEnum(int code, String detail) {
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
