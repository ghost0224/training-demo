package com.ibm.study.training.util;

import com.alibaba.fastjson.JSON;

public class CopyUtils {

    public static <T> T copy(Object source, Class<T> target) {
        if (null == source) {
            return null;
        }
        String jsonStr = JSON.toJSONString(source);
        System.out.println(jsonStr);
        return JSON.parseObject(jsonStr, target);
    }

}
