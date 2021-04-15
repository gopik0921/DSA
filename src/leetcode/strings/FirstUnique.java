package leetcode.strings;

import java.util.HashMap;
import java.util.Map;

public class FirstUnique {

	//Given a string s, return the first non-repeating character in it and return its index. If it does not exist, return -1.
	//Input: s = "loveleetcode"
	//Output: 2
	public static void main(String[] args) {
		firstUniqChar("leetl");
	}
	
	  public static int firstUniqChar(String s) {
	      Map<Character, Integer> count = new HashMap<>();
	        int n = s.length();
	        
	        for (int i = 0; i < n; i++) {
	            char c = s.charAt(i);
	            count.put(c, count.getOrDefault(c, 0) + 1);
	        }
	        
	        
	        for (int i = 0; i < n; i++) {
	            if (count.get(s.charAt(i)) == 1) 
	                return i;
	        }
	        return -1;
	    }
	    

}
