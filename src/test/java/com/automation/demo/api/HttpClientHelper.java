package com.automation.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpClientHelper {

    private HttpClient httpClient;
    private HttpResponse httpResponse;
    private String httpUrl;
    private Map<String, String> responseData;

    public Map<String, String> submitGetRequestAndReturnResponse(String endpointUrl) {
        responseData = new HashMap<>();

        httpClient = HttpClients.createDefault();

        httpUrl = endpointUrl;

        try {
            HttpGet httpGet = new HttpGet(httpUrl);

            httpResponse = httpClient.execute(httpGet);

            responseData.put("ResponseCode", String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            responseData.put("ResponseBody", EntityUtils.toString(httpResponse.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }

    public Map<String, String> submitPostRequestAndReturnResponse(String endpointUrl, String requestBody) {
        responseData = new HashMap<>();

        httpClient = HttpClients.createDefault();

        httpUrl = endpointUrl;

        try {
            HttpPost httpPost = new HttpPost(httpUrl);
            StringEntity stringEntity = new StringEntity(requestBody);

            httpPost.setEntity(stringEntity);

            httpResponse = httpClient.execute(httpPost);

            responseData.put("ResponseCode", String.valueOf(httpResponse.getStatusLine().getStatusCode()));
            responseData.put("ResponseBody", EntityUtils.toString(httpResponse.getEntity()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseData;
    }


}
