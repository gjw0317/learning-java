package com.practice.study.thread;

import com.practice.base.Constant;

/**
 * Created by junwuguo on 2017/2/13 0013.
 */
public class ThreadByThread extends Thread {
    private int food = 100;

    public void run() {
        for (int i = 0; i < Constant.MAX; i++) {
            if (food >= 0)
                System.out.println(Thread.currentThread().getName() + "\tthe number of food:\t" + food--);
        }
    }
}
