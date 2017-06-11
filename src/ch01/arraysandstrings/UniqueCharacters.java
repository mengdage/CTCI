package ch01.arraysandstrings;

public class UniqueCharacters {
	public boolean isUniqueChars(String str) {
		if(str.length() > 128) return false;
		
		boolean[] char_set = new boolean[128];
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if(char_set[val]){ 
				// Already found this char in string
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s1 = "linmeng";
		String s2 = "abcdefg";
		UniqueCharacters uc = new UniqueCharacters();
		System.out.println(uc.isUniqueChars(s1));
		System.out.println(uc.isUniqueChars(s2));
	}
}
