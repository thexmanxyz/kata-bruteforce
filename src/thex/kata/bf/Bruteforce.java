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

import java.util.Arrays;

public class Bruteforce {	
	private final static String ALPHA_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String ALPHA_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private final static String ALPHA_NUMERIC = "0123456789";
	private final static String ALPHA_SPECIAL = " !\"#$%&\'()*+,-./:;<=>?@[\\]^_`{|}~";
	
	private final char[] charset;
	private int[] idz = new int[1];
	private char[] result = new char[1];
	
	
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

	private char[] brute(){
		for(int i = 0; i < this.idz.length; i++){
			if(this.idz[i] < this.charset.length - 1){
				this.idz[i]++;
				this.result[i] = this.charset[this.idz[i]];
			}else{
				if(i + 1 == this.idz.length){
					this.idz = new int[this.idz.length + 1];
					this.result = new char[this.result.length + 1];
					Arrays.fill(this.idz, 0);
					Arrays.fill(this.result, charset[0]);
				}else{
					this.idz[i] = 0;
					this.result[i] = this.charset[this.idz[i]];
					continue;
				}
			}
			break;
		}
		return this.result;
	}
	
	public void find(String word, int maxLength){
		String find = "";
		do{
			find = new String(this.brute());			
			if(find.length() > maxLength)
				break;
		}while(!word.equals(find));
		
		if(word.equals(find))
		    System.out.println("Password: " + find);
		else
		    System.out.println("Password not found!");
	}
}
