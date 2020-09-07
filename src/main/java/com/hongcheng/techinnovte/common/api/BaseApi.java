package com.hongcheng.techinnovte.common.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class BaseApi {
    protected static Client client;

    protected Logger logger = LoggerFactory.getLogger(getClass());


    static {
        client = Client.create();
        client.setConnectTimeout(3000);
    }

    /**
     * 从response获取结果实体类
     */
    <T> Optional<T> getObjectFromResponse(Class<T> clazz, ClientResponse response) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            String entity = response.getEntity(String.class);

            try {
                JSONObject jsonObject = JSONObject.parseObject(entity);
                if ("0".equals(jsonObject.getString("code"))) {
                    String data = jsonObject.getString("data");

                    JSONArray datas = JSON.parseArray(data);

                    Iterator<Object> it = datas.iterator();
                    JSONObject dataObj = (JSONObject) it.next();// JSONArray中是很多个JSONObject对象 但我只要第一个

                    logger.info("objectId:" + dataObj.getString("targetId"));
                    return Optional.ofNullable(dataObj.getObject("targetId", clazz));
                }
            } catch (Exception e) {
                response.close();
                logger.error("解析返回结果失败: " + entity, e);
            }
        }

        return Optional.empty();
    }

    /**
     * 从response获取结果实体类
     */
    <T> Optional<T> getData(Class<T> clazz, ClientResponse response) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            String entity = response.getEntity(String.class);

            try {
                JSONObject jsonObject = JSONObject.parseObject(entity);
                if ("0".equals(jsonObject.getString("code"))) {
                    T data = jsonObject.getObject("data", clazz);
                    return Optional.ofNullable(data);
                }
            } catch (Exception e) {
                response.close();
                logger.error("解析返回结果失败: " + entity, e);
            }
        }

        return Optional.empty();
    }

    /**
     * 从response获取结果实体类
     */
    <T> List<T> getArrayFromResponse(Class<T> clazz, ClientResponse response) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            String entity = response.getEntity(String.class);
            try {
                JSONObject jsonObject = JSONObject.parseObject(entity);
                //响应结果为0--为success
                if ("0".equals(jsonObject.getString("code"))) {
                    //如果没有数据，则返回一个空的集合
                    if (jsonObject.getJSONArray("data") == null || jsonObject.getJSONArray("data").isEmpty()) {
                        return new ArrayList<>();
                    }
                    return jsonObject.getJSONArray("data").toJavaList(clazz);
                }
            } catch (Exception e) {
                response.close();
                logger.error("解析返回结果丢失: " + entity, e);
            }
        }

        return new ArrayList<>();
    }


    <T> Optional<T> getDataKJL(Class<T> clazz, ClientResponse response) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            String entity = response.getEntity(String.class);
            logger.info(entity);
            try {
                JSONObject jsonObject = JSONObject.parseObject(entity);
                if ("0".equals(jsonObject.getString("c"))) {
                    T data = jsonObject.getObject("d", clazz);
                    return Optional.ofNullable(data);
                }
            } catch (Exception e) {
                response.close();
                logger.error("解析返回结果失败: " + entity, e);
            }
            throw new RuntimeException(entity);

        }

        return Optional.empty();
    }

    JSONObject getDataWX(ClientResponse response) {
        if (response.getStatus() == HttpStatus.OK.value()) {
            String entity = response.getEntity(String.class);
            logger.info(entity);
            try {
                JSONObject jsonObject = JSONObject.parseObject(entity);
                return jsonObject;
            } catch (Exception e) {
                response.close();
                logger.error("解析返回结果失败: " + entity, e);
            }
            throw new RuntimeException(entity);
        }
        return null;
    }

}

