package com.note.thread.heima;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TraditionalTimerTest {

    public void test01() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("bombing!");
            }
        }, 10000, 3000);
    }

    private static int count = 0;

    public static void main(String[] args) {
        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2;
                System.out.println("bombing!");
                new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count);
            }
        }

        // 每隔两秒后每隔四秒执行
        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
