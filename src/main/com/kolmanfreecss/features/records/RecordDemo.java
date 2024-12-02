package com.kolmanfreecss.features.records;

public class RecordDemo {
    public static void main(String[] args) {
        // Create a record instance
        Person person = new Person("John Doe", 30);

        // Access fields using auto-generated accessors
        System.out.println("Name: " + person.name());
        System.out.println("Age: " + person.age());

        // Use toString method
        System.out.println("Person Details: " + person);

        // Use equals and hashCode
        Person anotherPerson = new Person("John Doe", 30);
        System.out.println("Are they equal? " + person.equals(anotherPerson));
    }

    // Record definition
    public record Person(String name, int age) {
        // Compact constructor for validation
        public Person {
            if (age < 0) {
                throw new IllegalArgumentException("Age must be non-negative");
            }
        }
    }
}

