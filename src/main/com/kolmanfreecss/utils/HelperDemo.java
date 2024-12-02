package com.kolmanfreecss.utils;

import java.util.List;

public class HelperDemo {
    public static void main(String[] args) {
        // Record example
        record Person(String name, int age) {}
        Person person = new Person("John Doe", 30);
        Helper.printRecordFields(person);

        // Virtual thread example
        Helper.runInVirtualThread(() -> System.out.println("Running in a virtual thread!"));

        // Text block example
        String textBlock = """
            Hello, %s!
            You have %d notifications.
            """;
        System.out.println(Helper.formatTextBlock(textBlock, "Alice", 5));

        // Collection processing example
        List<String> items = List.of("Apple", "Banana", "Cherry");
        Helper.processCollection(items);
    }
}
