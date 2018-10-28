package com.company;

import java.util.Scanner;

class MyThread implements Runnable {
    private boolean isActive = true;

    void disable() {
        this.isActive = false;
    }

    public void run() {
        System.out.printf("%s start \n", Thread.currentThread().getName());

        int i = 1;
        while(this.isActive) {
            System.out.printf("%s %s \n", Thread.currentThread().getName(), i++);

            try {
                Thread.sleep(400L);
            } catch (InterruptedException IE) {
                System.out.printf("Interrupted: \n%s", IE);
            }
        }
        System.out.printf("%s stop \n", Thread.currentThread().getName());
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MyThread t = new MyThread();

        String name = in.next();
        new Thread(t, name).start();

        String str = in.next();
        if (str.equals("s")) {
            t.disable();
        }
    }
}
