package com.kolmanfreecss.features.collections;

import java.util.List;
import java.util.Map;

public class CollectionsDemo {
    public static void collectionsFeatures() {
        // Immutable List
        List<String> names = List.of("Alice", "Bob", "Charlie");
        System.out.println("Immutable List: " + names);

        // Map with Entries
        Map<String, Integer> scores = Map.ofEntries(
                Map.entry("Alice", 95),
                Map.entry("Bob", 88),
                Map.entry("Charlie", 92)
        );
        System.out.println("Immutable Map with entries: " + scores);

        // Copy a list
        List<String> copy = List.copyOf(names);
        System.out.println("Copied List: " + copy);
    }
}
