package com.practice.test;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by junwuguo on 2017/2/16 0016.
 */
public class Practice {
    public static void main(String[] args) {
        Double d = 0.0;
        Long l = 0L;
        System.out.println(d);
        System.out.println(l);
        Map<String, String> map = new HashMap<>();

    }

    public static void generateUUID() {
        String uuid = UUIDUtil.generateUUID();
        System.out.println(uuid);
        StringBuilder tmp = new StringBuilder(uuid);
        tmp.setCharAt(0, '2');
        System.out.println(UUIDUtil.checkUUID(tmp.toString()));
    }

}
