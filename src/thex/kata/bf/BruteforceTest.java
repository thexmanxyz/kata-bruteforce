/*######################################################
 #                                                     #
 #   Iterative Bruteforce (Java)                       #
 #                                                     #
 #   Purpose: Small Kata Project to iterative          #
 #            find / bruteforce a predefined string.   #
 #                                                     #
 #                                                     #
 #   Author: Andreas Kar (thex) <andreas.kar@gmx.at>   #
 #                                                     #
/######################################################*/

package thex.kata.bf;

public class BruteforceTest {

	private final static String WORD = "*xA0";
	private final static int MAX_LENGTH = 4;
	
	public static void main(String[] args) {
		Bruteforce bf = Bruteforce.getBFAll();
		bf.find(WORD, MAX_LENGTH);
	}
}
