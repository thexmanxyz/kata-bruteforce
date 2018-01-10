/*######################################################'
 #                                                      #
 #   Iterative BruteForce (Java)                        #
 #                                                      #
 #   Purpose: Small Kata project to iteratively         #
 #            find / brute force a predefined string.   #
 #                                                      #
 #                                                      #
 #   Author: Andreas Kar (thex) <andreas.kar@gmx.at>    #
 #                                                      #
/#######################################################*/

package thex.kata.bf;

import java.util.Arrays;

public class Bruteforce {	
	private final static String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final static String ALPHA_NUMERIC = "0123456789";
	private final static String ALPHA_SPECIAL = " !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
	
	private final char[] charset;
	private int[] idz = new int[1];
	private char[] result = new char[1];
	private int iterations = 0;
	
	
	public Bruteforce(String charset) {
		this.charset = charset.toCharArray();
		this.idz[0] = -1;
	}
	
	public final static Bruteforce getBFAlphaLower(){
		return new Bruteforce(ALPHA_LOWER);
	}
	
	public final static Bruteforce getBFAlphaUpper(){
		return new Bruteforce(ALPHA_UPPER);
	}
	
	public final static Bruteforce getBFNumeric(){
		return new Bruteforce(ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFSpecial(){
		return new Bruteforce(ALPHA_SPECIAL);
	}
	
	public final static Bruteforce getBFAlphaNumericUpper(){
		return new Bruteforce(ALPHA_UPPER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAlphaNumericLower(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAlphaNumeric(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_UPPER + ALPHA_NUMERIC);
	}
	
	public final static Bruteforce getBFAll(){
		return new Bruteforce(ALPHA_LOWER + ALPHA_UPPER + ALPHA_NUMERIC + ALPHA_SPECIAL);
	}
	
	private char[] bruteIterative(String searchWord, int maxLength){
		char[] hSearch = searchWord.toCharArray();
		char[] find = new char[0];
		
		do{
			find = this.bruteIterativeInner();	
			
			// check if max length reached
			if(find.length > maxLength)
				return new char[0];
			
		// if search word found then escape
		}while(!Arrays.equals(hSearch, find));
		return find;
	}

	private char[] bruteIterativeInner(){
		for(int i = 0; i < this.idz.length; i++){
			
			// not reached char set limit, use next word on same place
			if(this.idz[i] < this.charset.length - 1){
				this.idz[i]++;
				this.result[i] = this.charset[this.idz[i]];
			}else{
				// char set limit reached on last position, increase word size by one and reset word
				if(i + 1 == this.idz.length){
					this.idz = new int[this.idz.length + 1];
					this.result = new char[this.result.length + 1];
					Arrays.fill(this.idz, 0);
					Arrays.fill(this.result, charset[0]);
					
				// char set limit reached on intermediate position, reset place and go on with next character position
				}else{
					this.idz[i] = 0;
					this.result[i] = this.charset[this.idz[i]];
					continue;
				}
			}
			break;
		}
		
		// update iterations
		this.iterations++;
		return this.result;
	}
	
	public void find(String word, int maxLength){
		long startTime = System.currentTimeMillis();
		String find = "";
		
		// reset iterations on reuse
		this.iterations = 0;
		
		// start the brute forcing
		find = new String(bruteIterative(word, maxLength));
		
		// output on result
		System.out.println("Time needed: " + (System.currentTimeMillis() - startTime) + "ms");
		System.out.println("Iterations required: " + iterations);
		if(word.equals(find))
		    System.out.println("Password: " + find);
		else
		    System.out.println("Password not found!");
		
	}
}