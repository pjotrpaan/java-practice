package com.Threads2;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SecondThread secondThread = new SecondThread();
        secondThread.setName("second");
        secondThread.start();

        Thread thirdThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from third thread.");
            }
        });

        thirdThread.start();
    }
}
