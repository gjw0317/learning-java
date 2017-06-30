package com.practice.study.server;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by junwuguo on 2017/2/22 0022.
 */
public class Client {

    public static void main(String[] args) throws JSONException, InterruptedException {
        while (true) {
            reportStatisticsData();
            Thread.sleep(Long.valueOf("5000").longValue());
        }
    }

    public static void reportStatisticsData() throws JSONException {
        try {
//            String url = "http://10.16.42.208:8000/overview";
            String url = "http://10.2.24.123:8001/overview";
//            String url = "http://192.168.56.101:8000/overview";
            Map<String, Object> result = new HashMap<String, Object>();
            Integer[] tmp = {1, 2, 3, 10, 4, 1, 8};
            List<Integer> list = Arrays.asList(tmp);
            result.put("deployment", tmp);
            result.put("year", 2017);
            result.put("month", 2);
            result.put("topic", "test");
            SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result.put("time", dateTimeFormat.format(new Date()));
            JSONObject jsonObject = new JSONObject(result);
//            sendPost(url, "overview", jsonObject.toString());
            String response = sendGet(url);
            System.out.println("response: " + response);
        } catch (Exception e) {
        }
    }

    private static void sendPost(String url, String formKey, String data) {
        System.out.println(data);
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<NameValuePair>();
        formParams.add(new BasicNameValuePair(formKey, data));
        UrlEncodedFormEntity urlEncodedFormEntity;
        try {
            urlEncodedFormEntity = new UrlEncodedFormEntity(formParams, "UTF-8");
            httpPost.setEntity(urlEncodedFormEntity);
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            try {
                HttpEntity httpEntity = httpResponse.getEntity();
                StatusLine statusLine = httpResponse.getStatusLine();
                String result = statusLine.getStatusCode() + " " + statusLine.getReasonPhrase();
                if (httpEntity != null) {
                    result += " " + EntityUtils.toString(httpEntity, "UTF-8");
                }
            } finally {
                httpResponse.close();
            }
        } catch (IOException e) {
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
//            String urlAll = url + "?uuid=0228&build_auto=1,2,3,4,5,6,7";
            String urlAll = url + "?build_auto=0%2C0%2C0%2C0%2C0%2C0%2C0&build_manual=0%2C0%2C0%2C0%2C0%2C0%2C0&deploy_auto=0%2C0%2C0%2C0%2C0%2C0%2C0&deploy_online=9%2C42%2C32%2C7%2C0%2C0%2C0&memory_using=57825506688.17313&memory_free=482097793663.8269&cpu_load_0=3&cpu_load_25=1&cpu_load_50=0&cpu_load_75=0&disk_using=10746964313975.465&disk_free=15578683738248.535&node_online=4&node_offline=0&project_collection=27&project_total=37&deploy_collection=18&deploy_total=109&image_project=21&storage_total=7&volume_total=0&uuid=24c3bb15020c4279b4c8143bc51fa878";
            URL realUrl = new URL(urlAll);
            URLConnection connection = realUrl.openConnection();
            connection.setRequestProperty("accept", "application/json, text/plain, */*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/56.0.2924.87 Safari/537.36");
            connection.connect();
            Map<String, List<String>> map = connection.getHeaderFields();
            for (String key:map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
        } finally {
            try {
                if(in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

}
