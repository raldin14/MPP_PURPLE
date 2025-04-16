package edu.miu.lab10.prob1.b;

import java.util.function.Supplier;

/**
 * Lab 10 - Part 1b (ii)
 * Using a lambda to print a random number.
 */
public class Part1bLambda {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number (Lambda): " + randomSupplier.get());
    }
}
