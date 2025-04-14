package edu.miu.lab9.prob2;

public class Evaluator {
    public static int eval(Expr expr) {
        return switch (expr) {
            case Constant c -> c.value();
            case Add a -> eval(a.left()) + eval(a.right());
            case Multiply m -> eval(m.left()) * eval(m.right());
            case null -> throw new IllegalArgumentException("Unknown expression type.");
        };
    }
}