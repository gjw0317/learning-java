package com.practice.study.enumClass;

/**
 * Created by junwuguo on 2017/2/16 0016.
 */
public enum EnumClass {
    ONE(EnumConstant.static_final_s),
    TWO(EnumConstant.static_s);

    private String stringValue;

    EnumClass(String stringValue) {
        this.stringValue = stringValue;
    }

    public String getValue() {
        return stringValue;
    }
}
