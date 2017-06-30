package com.practice.study.thread;

import java.util.concurrent.Callable;

/**
 * Created by junwuguo on 2017/2/15 0015.
 */
public class ThreadByCallable implements Callable<Integer> {
    private int a;
    private int b;

    public ThreadByCallable(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public Integer call() {
        int result = a / b;
        System.out.println(result);
        return result;
    }
}
