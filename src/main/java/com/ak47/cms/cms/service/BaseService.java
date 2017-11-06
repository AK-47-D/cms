package com.ak47.cms.cms.service;

import java.util.List;

/**
 * Created by wb-cmx239369 on 2017/11/6.
 */
public interface BaseService<T> {
    int save(T t);
    List<T> findAll();
    int delete(Long id);
    T findOne(Long id);
}
