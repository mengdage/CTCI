package ch01.arraysandstrings;

import java.util.Scanner;

public class Partition {

	 public static void main(String args[] ) throws Exception {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
	        Scanner in = new Scanner(System.in);
	        String s = in.next();
	        
	        // since lowercase and uppercase are considered the same
	        s = s.toLowerCase();
	        boolean[] alphabetChecker = new boolean[26];
	        int count = 0;
	        for(int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            
	            if(c>='a' && c <= 'z'){
	                if(!alphabetChecker[c-'a']){
	                    alphabetChecker[c-'a'] = true;
	                    count++;
	                    if(count == 26) {
	                        System.out.println("pangram");
	                        return;
	                    }
	                }
	            }
	        }
	        System.out.println("not pangram"+count);
	        
	        
	    }
}
