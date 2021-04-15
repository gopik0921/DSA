package leetcode.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringHalvesAlike {

	public static void main(String[] args) {
		boolean halvesAreAlike = halvesAreAlike("boo");
		System.out.println(halvesAreAlike);
	}

	public static boolean halvesAreAlike(String s) {
		int n = s.length();
		String a = s.substring(0, n / 2);
		String b = s.substring(n / 2, n);
		int ac = vowelCount(a);
		int bc = vowelCount(b);
		
		return ac==bc;
	}
	
	public static int vowelCount(String s) {
		List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int counter=0;
		for(int i=0;i<s.length();i++) {
        	if(list.contains(s.charAt(i))){
        		counter++;
        	}
        }
		
		return counter;
	}

}
