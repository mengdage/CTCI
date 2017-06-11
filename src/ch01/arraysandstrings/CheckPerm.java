package ch01.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckPerm {
	public String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	// use sort
	public boolean permutation(String s1, String s2) {
		if(s1.length() != s2.length()) return false;
		
		return sort(s1).equals(sort(s2));
	}
	
	// use frequency
	public boolean permutation2(String s1, String s2) {
		// check if the same length
		if(s1.length() != s2.length()) return false;
		
		Map<Character, Integer> frequency = new HashMap<Character, Integer>();
		for(int i = 0; i < s1.length(); i++) {
			char c = s1.charAt(i);
			if(frequency.containsKey(c)){
				frequency.put(c, frequency.get(c)+1);
			} else {
				frequency.put(c, 1);
			}
		}
		
		for(int i = 0; i < s2.length(); i++) {
			char c = s2.charAt(i);
			if(frequency.containsKey(c)){
				int newf = frequency.get(c)-1;
				if(newf<0){
					return false;
				}
				frequency.put(c, newf);
			}else { // the char c is not in s1
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		CheckPerm cp = new CheckPerm();
		String s1 = "linmeng";
		String s2 = "menglin";
		String s3 = "lin meng";
		String s4 = "linmenn";
		
		System.out.println(cp.permutation2(s1, s2));
		System.out.println(cp.permutation2(s1, s3));
		System.out.println(cp.permutation2(s1, s4));
	}
}
