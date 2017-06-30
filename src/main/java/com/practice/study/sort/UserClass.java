package com.practice.study.sort;

import java.util.Comparator;

/**
 * Created by junwuguo on 2017/2/17 0017.
 */
public class UserClass {
    private String name;
    private int age;

    public UserClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class UserComparator implements Comparator<UserClass> {
        @Override
        public int compare(UserClass u1, UserClass u2) {
            if (u1.getAge() > u2.getAge()) {
                return -1;
            } else if (u1.getAge() < u2.getAge()) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
