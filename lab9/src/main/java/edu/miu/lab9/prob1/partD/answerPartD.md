
- The equals() method is checking all fields (name, salary, and visited). 
- This may be fine for some cases, but here since we are only concerned about removing duplicates based on name and salary we should adjust the equals method to ignore the visited field.