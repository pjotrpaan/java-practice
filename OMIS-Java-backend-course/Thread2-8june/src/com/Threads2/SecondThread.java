package com.Threads2;

import org.w3c.dom.events.EventException;

public class SecondThread extends Thread {
    @Override
    public void run() {
        System.out.println("Hello from the second thread " + currentThread().getName() + "500 ms late to the party");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
