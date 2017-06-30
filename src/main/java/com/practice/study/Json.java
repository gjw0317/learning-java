package com.practice.study;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by junwuguo on 2017/6/26 0026.
 */
public class Json {

    public static void main(String[] args) {
        String jsonText = "{\"kind\":\"SerializedReference\",\"apiVersion\":\"v1\",\"reference\":{\"kind\":\"DaemonSet\",\"namespace\":\"default\",\"name\":\"dmo-17-demonset-v3\",\"uid\":\"db32e55a-5a39-11e7-a1c8-fa163ecf0254\",\"apiVersion\":\"extensions\",\"resourceVersion\":\"3143138\"}}";
        try {
            JSONObject jo = new JSONObject(jsonText);
            System.out.println(jo.get("reference"));
            JSONObject reference = jo.getJSONObject("reference");
            System.out.println(reference.toString());
            System.out.println(reference.get("kind"));
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
    }
}
