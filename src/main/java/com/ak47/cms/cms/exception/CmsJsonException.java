package com.ak47.cms.cms.exception;

public class CmsJsonException extends BaseCmsException {

    public CmsJsonException(String message) {
        super(message);
    }
    public CmsJsonException(String message,String title) {
        super(message);
        setTitle(title);
    }
    public CmsJsonException() {
    }
}
