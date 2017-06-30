package com.practice.study.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by junwuguo on 2017/2/17 0017.
 */
public class sortTest {
    public static void main(String[] args) {
        UserClass u1 = new UserClass("a", 10);
        UserClass u2 = new UserClass("b", 20);
        List<UserClass> userList = new ArrayList<UserClass>();
        userList.add(u1);
        userList.add(u2);
        show(userList);
        Collections.sort(userList, new UserClass.UserComparator());
        show(userList);
    }

    public static void show(List<UserClass> userList) {
        for (UserClass userClass: userList) {
            System.out.println(userClass.getName() + "\t" + userClass.getAge());
        }
    }


}
