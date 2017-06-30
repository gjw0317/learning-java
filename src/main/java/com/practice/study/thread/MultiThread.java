package com.practice.study.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by junwuguo on 2017/2/13 0013.
 */
public class MultiThread {
    public static void main(String[] args) {
//        testThreadByThread();
//        testThreadByRunnable();
//        testThreadByRunnable2();
        testThreadByCallable();
    }

    /**
     * Thread写法，不推荐使用
     * 3个线程，每个消费100个食物，总共消费300个食物
     */
    public static void testThreadByThread() {
        ThreadByThread tbt1 = new ThreadByThread();
        ThreadByThread tbt2 = new ThreadByThread();
        ThreadByThread tbt3 = new ThreadByThread();
        tbt1.start();
        tbt2.start();
        tbt3.start();
    }

    /**
     * Runnable写法，推荐使用
     * 3个线程共用一个Runnable对象
     * 3个线程，总共消费100个食物
     * todo:可能会不止100个食物
     */
    public static void testThreadByRunnable() {
        ThreadByRunnable tbr = new ThreadByRunnable();
        Thread t1 = new Thread(tbr);
        Thread t2 = new Thread(tbr);
        Thread t3 = new Thread(tbr);
        t1.start();
        t2.start();
        t3.start();
    }

    /**
     * Runnable写法，推荐使用
     * 3个线程分别使用一个Runnable对象
     * 3个线程，每个消费100个食物，总共消费300个食物
     */
    public static void testThreadByRunnable2() {
        Thread t1 = new Thread(new ThreadByRunnable());
        Thread t2 = new Thread(new ThreadByRunnable());
        Thread t3 = new Thread(new ThreadByRunnable());
        t1.start();
        t2.start();
        t3.start();
    }

    public static void testThreadByCallable() {
        ThreadByCallable tbc1 = new ThreadByCallable(10, 2);
        ThreadByCallable tbc2 = new ThreadByCallable(0, 2);
        ThreadByCallable tbc3 = new ThreadByCallable(10, 0);

        ExecutorService exec = Executors.newFixedThreadPool(5);
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();
        results.add(exec.submit(tbc1));
        results.add(exec.submit(tbc2));
        results.add(exec.submit(tbc3));

        for (Future<Integer> future : results) {
            try {
                System.out.println("future:\t" + future.get(3, TimeUnit.SECONDS));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
