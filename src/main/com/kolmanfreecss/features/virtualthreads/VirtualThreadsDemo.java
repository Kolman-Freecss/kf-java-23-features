package com.kolmanfreecss.features.virtualthreads;

import java.util.concurrent.Executors;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        // Using virtual threads with Executors
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                final int taskId = i;
                executor.submit(() -> {
                    System.out.println("Executing Task " + taskId + " on Thread: " + Thread.currentThread());
                    Thread.sleep(1000); // Simulate a task
                    return taskId;
                });
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
            System.err.println("Executor was interrupted: " + e.getMessage());
        }

        // Example using Thread.ofVirtual()
        Thread thread = Thread.ofVirtual().start(() -> {
            System.out.println("Virtual thread running task...");
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
            System.out.println("Task finished.");
        });

        // Wait for the thread to complete
        try {
            thread.join();
        } catch (Exception e) {
            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}
