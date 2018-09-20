/*#######################################################
 #                                                      #
 #   Kata - Iterative Bruteforce                        #
 #                                                      #
 #   Purpose: Small Kata project to iteratively         #
 #            find / brute force a predefined string.   #
 #                                                      #
 #   Author: Andreas Kar (thex) <andreas.kar@gmx.at>    #
 #   Repository: https://git.io/fAHyg                   #
 #                                                      #
/#######################################################*/

package thex.kata.bf;

public class BruteforceTest {

	private final static String WORD = "+#xy";
	private final static int MAX_LENGTH = 4;
	
	public static void main(String[] args) {
		System.out.println("Start Iterative Bruteforce:");
		Bruteforce bf = Bruteforce.getAllChars();
		bf.find(WORD, MAX_LENGTH);
	}
}
