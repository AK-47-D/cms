package com.ak47.cms.cms.enums;

public enum ManageFromEnum {
    SYSTEM(0,"system"),
    PBC(1,"PBC");
    private int code;
    private String cb;

    ManageFromEnum(int code, String cb) {
        this.code = code;
        this.cb = cb;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCb() {
        return cb;
    }

    public void setCb(String cb) {
        this.cb = cb;
    }
}
