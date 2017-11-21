package com.ak47.cms.cms.exception;

public class CmsViewException extends BaseCmsException {

    public CmsViewException(String message) {
        super(message);
    }
    public CmsViewException() {
    }
    public CmsViewException(String message,String title) {
        super(message);
        setTitle(title);
    }
}
