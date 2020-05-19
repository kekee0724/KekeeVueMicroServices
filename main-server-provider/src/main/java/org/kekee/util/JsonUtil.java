package org.kekee.util;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @author cocoa
 */
public class JsonUtil {
    public static <T> T map2obj(Map<?, ?> map, Class<T> clazz) throws Exception {
        return JSON.parseObject(JSON.toJSONString(map), clazz);
    }
}
