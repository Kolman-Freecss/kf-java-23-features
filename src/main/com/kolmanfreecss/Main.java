package com.kolmanfreecss;

import com.kolmanfreecss.features.StringTemplatesDemo;
import com.kolmanfreecss.features.collections.CollectionsDemo;
import com.kolmanfreecss.features.patternmatching.PatternMatchingDemo;
import com.kolmanfreecss.features.records.RecordDemo;
import com.kolmanfreecss.features.virtualthreads.VirtualThreadsDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exploring Java 23 Features...");

        // Collections Features
        CollectionsDemo.collectionsFeatures();

        // Pattern Matching
        PatternMatchingDemo.patternMatchingFeatures(15);
        PatternMatchingDemo.patternMatchingFeatures("Hello");
        PatternMatchingDemo.patternMatchingFeatures(null);

        // String Templates
        StringTemplatesDemo.stringTemplatesFeature();

        // Records
        RecordDemo.main(null);

        // Virtual Threads
        VirtualThreadsDemo.main(null);

        System.out.println("Java 23 Features explored successfully!");
    }
}
