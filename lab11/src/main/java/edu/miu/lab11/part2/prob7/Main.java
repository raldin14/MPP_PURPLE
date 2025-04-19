package edu.miu.lab11.part2.prob7;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 5, -2, 0, -3, -1, -5, -4);
		//expected output: [0, -1, -2, -3, -4, 4, -5, 5]
		ordering1(intList);
		List<String> stringList = Arrays.asList("cba", "efg", "doe", "fie", "set");
		//expected output: [cba, fie, doe, efg, set]
		ordering2(stringList);
		
	}
	/* 
 * In the code folder for this lab, prob7, there is a Main class with a main method that prepares
some data and calls two (unimplemented) methods: ordering1 and ordering2. Each of
these methods is supposed to sort a given input list in a stream pipeline – using a non-standard
ordering rule which must be specified using comparing and thenComparing – and then
output as a sorted list, which is then to be printed to the console.
ordering1(List<Integer>) : The ordering of integers to be used here is one that
would sort the integers in the following way:
 0, -1, 1, -2, 2, -3, 3, . . .
 */
	//Orders the integers according to this pattern:
	// 0, -1, 1, -2, 2, -3, 3, . . .
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
	public static void ordering1(List<Integer> list) {
		System.out.println(list.stream()
								.sorted(Comparator.comparing(x -> x))
								.sorted(Comparator.comparing(Math::abs))
								.toList()
							);
		
	}
	/* 
 * ordering2(List<String>): The ordering of Strings to be used here is the following:
 s precedes t if and only if reverse(s) comes
 before reverse(t) in the usual ordering of strings.
For example, in using ordering2, "cba" precedes "bbd" because, when the strings are
reversed, we see that "abc" precedes "dbb" in the usual string ordering.
In the main method, the expected outputs of each of these methods are shown.
 */
	//Orders words by first reversing each and comparing 
	//in the usual way.  So 
	//    cba precedes bed
	//since
	//    cba.reverse() precedes bed.reverse()
	//in the usual ordering
	//Using this ordering, this method sorts the list as part of 
	//a stream pipeline, and prints to the console
	public static void ordering2(List<String> words) {
		System.out.println(words.stream()
					.sorted(Comparator.comparing(s -> new StringBuilder(s).reverse().toString()))
					.toList());
				
	}

}
