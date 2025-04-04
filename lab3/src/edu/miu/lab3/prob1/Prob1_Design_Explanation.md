## ✅ Problem 1: Design Justification and Refactoring Explanation

### 🔍 Issue Identified:
Using inheritance (`PersonWithJob extends Person`) led to `equals()` violating the **symmetry rule**, because:
- `p1.equals(p2)` returns `false` (calls PersonWithJob.equals)
- `p2.equals(p1)` returns `true` (calls Person.equals)

❗ Why This Is a Problem
According to Java’s contract:

For any non-null values x and y, x.equals(y) should always return the same as y.equals(x).

But here, that's not happening — and that can lead to serious bugs when using sets, maps, or comparisons.

### ✅ Solution:
- Replaced inheritance with **composition**: `PersonWithJob` now **has-a** `Person`.
- Delegated name-related logic to the composed `Person` object. (It's like a PersonWithJob having a personal assistant (Person) who keeps the name information. When asked for the name, PersonWithJob simply asks the assistant to provide it.)
- This resolved the symmetry problem and improved design flexibility.
- When you use composition, cross-type comparisons like this should naturally be avoided.
