package com.kolmanfreecss.features;

public class StringTemplatesDemo {
    public static void stringTemplatesFeature() {
        int apples = 5;

        // Use String.format for a template-like behavior
        String template = String.format("You have %d apples.", apples);
        System.out.println("String Template: " + template);
    }

    public static void main(String[] args) {
        stringTemplatesFeature();
    }
}
