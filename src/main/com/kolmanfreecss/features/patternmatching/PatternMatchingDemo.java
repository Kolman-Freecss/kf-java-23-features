package com.kolmanfreecss.features.patternmatching;

public class PatternMatchingDemo {
    public static void patternMatchingFeatures(Object input) {
        String result = switch (input) {
            case Integer i when i > 10 -> "Integer greater than 10: " + i;
            case Integer i -> "Integer less than or equal to 10: " + i;
            case String s -> "It's a String: " + s;
            case null -> "Input is null";
            default -> "Unknown type";
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        patternMatchingFeatures(15); // Output: Integer greater than 10: 15
        patternMatchingFeatures(5);  // Output: Integer less than or equal to 10: 5
        patternMatchingFeatures("Hello"); // Output: It's a String: Hello
        patternMatchingFeatures(null); // Output: Input is null
        patternMatchingFeatures(3.14); // Output: Unknown type
    }
}
