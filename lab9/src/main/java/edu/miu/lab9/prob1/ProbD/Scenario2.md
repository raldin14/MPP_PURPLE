ii. When the type D is an interface.

B and C both override A’s default method. When D implements both, Java forces you to override the method in D to eliminate ambiguity. We can call one explicitly using B.super.doSomething() or C.super.doSomething().