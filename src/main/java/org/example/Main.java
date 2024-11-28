package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WorkerThread worker = new WorkerThread("My Worker");
        Scanner scanner = new Scanner(System.in);

        WorkerTask task;

        while (true) {
            System.out.println("Input a task to execute or \"end\" to exit:");
            String input = scanner.nextLine();

            if (input.isBlank()) continue;

            if (input.equalsIgnoreCase("end")) {
                worker.interrupt();
                System.out.println("Bye bye");
                break;
            }

            if (!worker.isAlive()) {
                worker.start();
            }

            task = new WorkerTask(input);

            System.out.println("Sending the task for execution..");
            worker.addTask(task);
            Thread.sleep(2000L);
        }
    }
}