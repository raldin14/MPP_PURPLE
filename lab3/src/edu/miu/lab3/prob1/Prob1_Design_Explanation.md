## ✅ Problem 1: Design Justification and Refactoring Explanation

### 🔍 Issue Identified:
Using inheritance (`PersonWithJob extends Person`) led to `equals()` violating the **symmetry rule**, because:
- `p1.equals(p2)` returns `false` (calls PersonWithJob.equals)
- `p2.equals(p1)` returns `true` (calls Person.equals)

### ✅ Solution:
- Replaced inheritance with **composition**: `PersonWithJob` now **has-a** `Person`.
- Delegated name-related logic to the composed `Person` object.
- This resolved the symmetry problem and improved design flexibility.
