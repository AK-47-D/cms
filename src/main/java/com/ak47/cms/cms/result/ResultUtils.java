package com.ak47.cms.cms.result;

import java.util.List;

public class ResultUtils {
    private ResultUtils(){

    }
    public  static <T>Result<PageResult<T>> instancePageResult(int pageNum, int pageSize, List<T> rows,boolean success){
        return instancePageResult(pageNum,pageSize,rows,null,success);
    }

    public  static <T>Result<PageResult<T>> instancePageResult(int pageNum, int pageSize, List<T> rows,String message,boolean success){
        return instancePageResult(pageNum,pageSize,rows,message,success,null);
    }

    public  static <T>Result<PageResult<T>> instancePageResult(int pageNum, int pageSize, List<T> rows,String message,boolean success,String title){
        PageResult<T> pageResult = new PageResult<>();
        pageResult.setPageNum(pageNum);
        pageResult.setPageSize(pageSize);
        pageResult.setRows(rows);
        return instanceResult(message,pageResult,success,title);
    }

    public  static <T>Result<T> instanceResult(String message,T result,boolean success,String title){
        Result<T> r = new Result<>();
        r.setMessage(message);
        r.setResult(result);
        r.setSuccess(success);
        r.setTitle(title);
        return r;
    }
    public  static <T>Result<T> instanceResult(String message,T result,boolean success){
        return instanceResult(message,result,success,null);
    }
    public  static <T>Result<T> instanceResult(T result,boolean success){
        return instanceResult(null,result,success);
    }
    public  static <T>Result<T> instanceResult(boolean success){
        return instanceResult(null,success);
    }
}
