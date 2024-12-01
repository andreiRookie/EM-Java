package org.example;

public class WorkerTask implements Runnable {

    private final String task;

    public WorkerTask(String task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            System.out.println("Start to work..");
            Thread.sleep(500L);

            System.out.println("..still working..");
            Thread.sleep(500L);

            System.out.println("Task \"" + task + "\" completed!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
