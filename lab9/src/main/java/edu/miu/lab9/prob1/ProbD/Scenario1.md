i. When the type D is a class

If A has a method void doSomething(), and B and C both override it, D won’t know which version to inherit unless explicitly resolved. Java avoids this problem entirely by disallowing multiple class inheritance. So, in this example, class D must choose to extend either B or C, but not both, since in Java, you cannot inherit from multiple classes abstract or concrete. So the following is illegal 

abstract class A {
    abstract void doSomething();
}

class B extends A {
    void doSomething() {
        System.out.println("B says Hello");
    }
}

class C extends A {
    void doSomething() {
        System.out.println("C says Hello");
    }
}

//Compilation Error
class D extends B, C {  // Not allowed in Java
    // ...
}
