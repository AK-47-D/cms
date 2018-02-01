package com.ak47.cms.cms.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnumUtil {
    private EnumUtil(){

    }
    public static <T> List<Map<String,Object>> getList(T ...ts){
        List<Map<String,Object>> list = new ArrayList<>();
        for(T t:ts) {
            Method[] methods= t.getClass().getMethods();
            Map<String, Object> map = new HashMap<>();
            for (Method method : methods) {
                if (method.getName().startsWith("get")) {
                    try {
                        map.put(method.getName().substring(3,4).toLowerCase()+method.getName().substring(4), method.invoke(t));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
            list.add(map);
        }
        return list;
    }
}
