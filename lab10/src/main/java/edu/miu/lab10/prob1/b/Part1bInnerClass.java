package edu.miu.lab10.prob1.b;

import java.util.function.Supplier;

/**
 * Lab 10 - Part 1b (iii)
 * Using an inner class to implement Supplier<Double> for Math.random().
 */
public class Part1bInnerClass {
    // Inner class that implements Supplier<Double>
    static class RandomSupplier implements Supplier<Double> {
        @Override
        public Double get() {
            return Math.random();
        }
    }

    public static void main(String[] args) {
        Supplier<Double> supplier = new RandomSupplier();
        System.out.println("Random number (Inner class): " + supplier.get());
    }
}
