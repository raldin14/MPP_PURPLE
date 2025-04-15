
Part B:

- Problem:
The hashcode was not overwritten in the Employee class
removeDuplicates() method relies on HashMap, which requires both equals() and hashCode() to function correctly equals() method alone isn't enough; If hashCode() isn’t consistent with equals(), duplicates won’t be properly identified or removed

Solution

- Implemented the hasCode method