package org.example;

import java.util.*;

public class WorkerThread extends Thread {

    private final String name;

    private final LinkedList<Runnable> linkedList = new LinkedList<>();

    public WorkerThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                if (linkedList.isEmpty()) {
                    sleep(500L);
                } else {
                    linkedList.poll().run();
                }
            }
        } catch (InterruptedException e) {
            System.out.println(name + " has been interrupted");
            interrupt();
        }
        System.out.printf("%s finished", name);
    }

    public void addTask(Runnable task) {
        linkedList.offer(task);
    }
}
