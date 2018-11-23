package com.example.directories.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JsonUtility {
   // private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static String convertBean2Json(Object bean) {
        ObjectMapper mapper=new ObjectMapper();
        String json="";
        try{
            json=mapper.writeValueAsString(bean);
        }
        catch (JsonProcessingException e){
           // logger.error("json转换失败:"+bean+" ex:"+e.getMessage());
        }
        return json;
    }
}
