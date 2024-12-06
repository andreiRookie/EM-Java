package org.example;

import java.util.*;

public class WorkerThread extends Thread {

    private final String name;

    private final Deque<Runnable> deque = new ArrayDeque<>();

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                if (deque.isEmpty()) {
                    sleep(500L);
                } else {
                    deque.poll().run();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " has been interrupted");
            interrupt();
        }
        System.out.printf("%s finished", name);
    }

    public void addTask(Runnable task) {
        deque.offer(task);
    }
}
