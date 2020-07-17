package com.Threads;

public class Main {

    static String[] threadNames = {"Pets", "Mihkel", "Anto"};

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < threadNames.length; i++) {
            new Thread(getRunnable()).start();
            Thread.sleep(500);
        }

    }

    public static Runnable getRunnable() {
        return () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                try {
                    Thread.sleep(5500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}
