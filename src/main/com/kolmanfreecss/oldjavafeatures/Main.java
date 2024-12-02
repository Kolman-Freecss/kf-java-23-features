package com.kolmanfreecss.oldjavafeatures;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // 1. Using Optionals to handle nulls safely
        optionalFeature();

        // 2. Exploring Java Streams API
        streamsFeature();

        // 3. Lambda Expressions and Functional Interfaces
        lambdaFeature();

        // 4. Collectors - Grouping and Partitioning
        collectorsFeature();

        // 5. Using the `CompletableFuture` for Asynchronous Programming
        completableFutureFeature();

        // 6. Using `Map` with `compute` for atomic updates
        mapComputeFeature();
    }

    // 1. Handling nulls safely with Optionals
    static void optionalFeature() {
        System.out.println("=== Optional Feature ===");

        // Creating Optionals from non-null and null values
        Optional<String> nonEmpty = Optional.of("Hello");
        Optional<String> empty = Optional.empty();

        // Using ifPresent to check if value exists
        nonEmpty.ifPresent(value -> System.out.println("Value: " + value));

        // Using orElse for default value when the Optional is empty
        String defaultValue = empty.orElse("Default Value");
        System.out.println("Empty Optional: " + defaultValue);

        // Using map and filter to operate on Optionals
        Optional<String> mapped = nonEmpty.map(value -> value.toUpperCase());
        System.out.println("Mapped Value: " + mapped.orElse("Empty"));

        // Using orElseThrow to throw an exception if the value is missing
        try {
            String value = empty.orElseThrow(() -> new NoSuchElementException("Value not present"));
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println();
    }

    // 2. Exploring Java Streams API
    static void streamsFeature() {
        System.out.println("=== Streams Feature ===");

        // Creating a list of integers
        List<Integer> numbers = List.of(5, 8, 3, 10, 15, 1, 7, 12);

        // Using streams to process collections
        List<Integer> filteredNumbers = numbers.stream()
                .filter(n -> n > 5)
                .sorted()
                .collect(Collectors.toList());

        System.out.println("Filtered Numbers: " + filteredNumbers);

        // Using map to apply a function and collecting the results
        List<String> stringNumbers = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println("Mapped to String: " + stringNumbers);

        // Using reduce to perform a reduction operation (sum of numbers)
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);

        System.out.println();
    }

    // 3. Lambda Expressions and Functional Interfaces
    static void lambdaFeature() {
        System.out.println("=== Lambda Expressions and Functional Interfaces ===");

        // Using a simple lambda expression to define a Runnable
        Runnable runnable = () -> System.out.println("Running a thread using Lambda!");
        runnable.run();

        // Using lambda with a custom functional interface
        List<String> names = List.of("Alice", "Bob", "Charlie");

        // Printing each name using a lambda expression
        names.forEach(name -> System.out.println("Name: " + name));

        // Using a lambda with a comparator to sort a list
        names.sort((a, b) -> b.compareTo(a));  // Sort names in reverse order
        System.out.println("Sorted Names: " + names);

        System.out.println();
    }

    // 4. Collectors - Grouping and Partitioning
    static void collectorsFeature() {
        System.out.println("=== Collectors Feature ===");

        // Example data: list of people with age
        class Person {
            String name;
            int age;

            Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }
        }

        List<Person> people = List.of(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("David", 30)
        );

        // Group people by age
        Map<Integer, List<Person>> groupedByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println("Grouped by Age: " + groupedByAge);

        // Partition people into those who are over 30 or not
        Map<Boolean, List<Person>> partitioned = people.stream()
                .collect(Collectors.partitioningBy(p -> p.getAge() > 30));

        System.out.println("Partitioned by Age > 30: " + partitioned);

        System.out.println();
    }

    // 5. CompletableFuture for Asynchronous Programming
    static void completableFutureFeature() {
        System.out.println("=== CompletableFuture Feature ===");

        // Creating an asynchronous task
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);  // Simulate long computation
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;  // The result of the task
        });

        // Handling the result once it's completed
        future.thenAccept(result -> System.out.println("The result is: " + result));

        // Wait for the future to complete (blocking operation for demonstration)
        future.join();  // This will block until the task is finished

        System.out.println();
    }

    // 6. Using `Map` with `compute` for Atomic Updates
    static void mapComputeFeature() {
        System.out.println("=== Map Compute Feature ===");

        // Using compute() to atomically modify map values
        Map<String, Integer> wordCount = new HashMap<>();
        wordCount.put("apple", 3);
        wordCount.put("banana", 2);

        // Incrementing the count of 'apple' atomically
        wordCount.compute("apple", (key, value) -> value == null ? 1 : value + 1);
        wordCount.compute("orange", (key, value) -> value == null ? 1 : value + 1);

        System.out.println("Word Count: " + wordCount);

        System.out.println();
    }
}
