package com.zhang.nio;

import org.junit.Test;

import java.util.Random;

public class TestThreadLocal {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    class TestRunable implements Runnable{
        @Override
        public void run() {
            Random random = new Random();
            Integer integer = random.nextInt();
            System.out.println(integer);
            threadLocal.set(integer);

            System.out.println(threadLocal.get());
        }
    }
    @Test
    public void test(){
        for(int i=0;i<3;i++){
            new Thread(new TestRunable()).start();
        }
    }
    public static void main(String[] args)
    {

    }
}
