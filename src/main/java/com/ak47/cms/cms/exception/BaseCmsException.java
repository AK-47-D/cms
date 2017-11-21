package com.ak47.cms.cms.exception;

public class BaseCmsException extends RuntimeException {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseCmsException(String message) {
        super(message);
    }
    public BaseCmsException() {
    }
    public static String getStackMsg(Throwable e) {

        StringBuffer sb = new StringBuffer();
        StackTraceElement[] stackArray = e.getStackTrace();
        sb.append(e.getClass().getName() + "\n");
        for (int i = 0; i < stackArray.length; i++) {
            StackTraceElement element = stackArray[i];
            sb.append(element.toString() + "\n");
        }
        return sb.toString();
    }
}
