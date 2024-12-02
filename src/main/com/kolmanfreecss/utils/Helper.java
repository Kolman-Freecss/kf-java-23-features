package com.kolmanfreecss.utils;

import java.util.concurrent.Executors;

public class Helper {

    /**
     * A helper method to print the fields of a record.
     */
    public static void printRecordFields(Object record) {
        if (record instanceof Record rec) {
            System.out.println("Record fields: ");
            for (var component : rec.getClass().getRecordComponents()) {
                try {
                    System.out.println(component.getName() + " = " + component.getAccessor().invoke(record));
                } catch (Exception e) {
                    System.out.println("Error accessing field: " + component.getName());
                }
            }
        } else {
            System.out.println("Provided object is not a record.");
        }
    }

    /**
     * A helper method to demonstrate the use of virtual threads.
     */
    public static void runInVirtualThread(Runnable task) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(task);
        }
    }

    /**
     * A helper method to create a formatted string for text blocks.
     */
    public static String formatTextBlock(String textBlock, Object... args) {
        return textBlock.formatted(args);
    }

    /**
     * A helper method to process and print elements from a collection.
     */
    public static <T> void processCollection(Iterable<T> collection) {
        System.out.println("Processing collection:");
        for (T item : collection) {
            System.out.println("- " + item);
        }
    }
}
