package main.java.edu.miu.lab10.prob4;

import java.util.ArrayList;
import java.util.List;

/**
  * Implement a method with the following signature and return type:
 public int countWords(List<String> words, char c, char d, int len)
which counts the number of words in the input list words that have length equal to len, that
contain the character c, and that do not contain the character d. Create a solution like the "Good"
solution in lesson8.lecture.filter (use the method findStartsWithLetterOld as an example).
  */
public class CountingWords {
    public static int countWords(List<String> words, char c, char d, int len){
            
            return (int) words.stream()
                                .filter(word -> word.length() == len)
                                .filter(word -> word.toLowerCase().indexOf(c) >= 0)
                                .filter(word -> word.toLowerCase().indexOf(d) == -1)
                                .count();
        }
    
        public static void main(String[] args) {
            List<String> words = new ArrayList<>();
    
            words.add("Hello");
            words.add("Ello");
            words.add("Dello");
            words.add("Hola");
            words.add("Holla");
            words.add("HolDa");
            System.out.println(countWords(words, 'h', 'd', 5));
    }
}
