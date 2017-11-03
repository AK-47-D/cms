package com.ak47.cms.cms.enums;

/**
 * Created by wb-cmx239369 on 2017/11/3.
 */
public enum NewsType {

    CENTRAL_BANK(0,"央行");

    private int typeCode;
    private String mark;

    NewsType(int typeCode,String mark) {
        this.mark = mark;
        this.typeCode = typeCode;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
