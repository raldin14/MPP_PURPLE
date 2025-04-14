package edu.miu.lab9.prob2;

public sealed interface Expr permits Constant, Add, Multiply {}
