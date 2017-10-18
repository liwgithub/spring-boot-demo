package com.baiding.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by BaiDing on 2017/10/18.
 */
public class GlobalObject {

    private static volatile ObjectMapper jsonMapper;

    public static ObjectMapper getJsonMapper() {
        if(jsonMapper==null){
            jsonMapper = new ObjectMapper();
        }
        return jsonMapper;
    }
}
