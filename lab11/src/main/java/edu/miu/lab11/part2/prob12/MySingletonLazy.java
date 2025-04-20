package edu.miu.lab11.part2.prob12;

import java.util.Optional;

public class MySingletonLazy {
    private static MySingletonLazy instance = null;

    private MySingletonLazy() {
        System.out.println("Singleton instance created!");
    }

    public static MySingletonLazy getInstance() {
        instance = Optional.ofNullable(instance)
                .orElseGet(MySingletonLazy::new);
        return instance;
    }

    // Main method to test
    public static void main(String[] args) {
        MySingletonLazy obj1 = MySingletonLazy.getInstance();
        MySingletonLazy obj2 = MySingletonLazy.getInstance();
        System.out.println("Are both instances the same? " + (obj1 == obj2));
    }
}
