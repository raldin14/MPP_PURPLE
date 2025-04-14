package edu.miu.lab9.prob2;

import static edu.miu.lab9.prob2.Evaluator.eval;

public class Main {
    public static void main(String[] args) {
        Expr expression = new Multiply(
                new Add(new Constant(2), new Constant(3)),
                new Constant(4)
        );

        int result = eval(expression);
        System.out.println("Result: " + result); // Output: 20
    }
}
