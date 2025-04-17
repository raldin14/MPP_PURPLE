package edu.miu.lab11.prob3;

import java.util.stream.Stream;

public class PrimeStream {

    // Helper method: Check if a number is prime
    private boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Method to create a fresh infinite Stream of primes each time it's called
    private Stream<Integer> generatePrimes() {
        return Stream.iterate(2, n -> n + 1)
                .filter(this::isPrime); // filtering inside stream
    }

    // Method to print first n primes
    public void printFirstNPrimes(long n) {
        generatePrimes()
                .limit(n)
                .forEach(System.out::println);
    }

    // Main to test calling multiple times
    public static void main(String[] args) {
        PrimeStream ps = new PrimeStream();
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);
    }
}
