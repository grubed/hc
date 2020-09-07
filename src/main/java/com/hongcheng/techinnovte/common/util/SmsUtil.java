package com.hongcheng.techinnovte.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jdom.JDOMException;

import com.hongcheng.techinnovte.pojo.dto.MtDTO;
import com.hongcheng.techinnovte.common.enumeration.LetterType;
@Slf4j
public class SmsUtil {

    private static final String SMS_URL = "http://112.74.76.186:8030/service/httpService/httpInterface.do?method=sendUtf8Msg";
    private static final String SMS_USERNAME = "JSM41810";
    private static final String SMS_VERTCODE = "rvag9v1xaygl";
    private static final String SMS_PASSWORD = "vei4ryvk";
    private static final String SMS_MSGTYPE = "2";

    public static Boolean SmsSend(LetterType letter, String tels, String... contents) throws JDOMException, IOException {
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", SMS_USERNAME));
        params.add(new BasicNameValuePair("veryCode", SMS_VERTCODE));
        params.add(new BasicNameValuePair("password", SMS_PASSWORD));
        params.add(new BasicNameValuePair("msgtype", SMS_MSGTYPE));
        params.add(new BasicNameValuePair("tempid", letter.getTemplate()));
        params.add(new BasicNameValuePair("mobile", tels));
        if(null != contents && contents.length > 0) {//设置短信内容
        	StringBuilder buff = new StringBuilder();
        	for(int i = 0 ; i < contents.length ; i++) {
        		buff.append(",").append("@").append(i+1).append("@=").append(contents[i]);
        	}
        	params.add(new BasicNameValuePair("content", buff.substring(1)));
        }
        String resultMsg = post(SMS_URL, params);
        log.info(tels+" "+resultMsg);
        Map<String, MtDTO> ret = XMLUtil.doXMLParseMt(resultMsg);

        if("0".equals(ret.get("mt").getStatus())) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }

    }

    public static String post(String url, List<NameValuePair> pairList) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            method.setEntity(new UrlEncodedFormEntity(pairList, "UTF-8"));
            response = client.execute(method);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity, "UTF8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }

    public static String buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return String.valueOf((int)(random * num));
    }
}