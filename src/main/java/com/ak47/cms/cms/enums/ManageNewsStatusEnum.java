package com.ak47.cms.cms.enums;

public enum ManageNewsStatusEnum {
    RELEASE(0,"发布"),
    DRAFT(1,"草稿");
    private int code;
    private String detail;

    ManageNewsStatusEnum(int code, String detail) {
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
