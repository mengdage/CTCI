package ch01.arraysandstrings;

public class Compress {
	public String compress(String str) {
		StringBuilder sb = new StringBuilder();
		char last = str.charAt(0);
		int count = 1;
		for(int i = 1; i < str.length(); i++) {
			if(str.charAt(i) == last) { // repeat char
				count++;
			} else { // not repeat
				// add char and count to sb
				sb.append(last);
				sb.append(count);
				// update last and count
				last = str.charAt(i);
				count = 1;
			}
		}
		
		sb.append(last);
		sb.append(count);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s = "aabbcccedffgs";
		System.out.println(new Compress().compress(s));
	}
}
