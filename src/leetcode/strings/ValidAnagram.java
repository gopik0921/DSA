package leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, return true if t is an anagram of s, and false otherwise.
//Input: s = "anagram", t = "nagaram"
//Output: true
public class ValidAnagram {

	public static void main(String[] args) {
		boolean anagram = isAnagram2("car", "rat");
		System.out.println(anagram);
		int[] arr=new int[]{0,1,2,3};
		arr[0]++;
		System.out.println(arr[0]);
	}

	// O(n log n)
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] charArray = s.toCharArray();
		char[] charArray2 = t.toCharArray();
		Arrays.sort(charArray2);
		Arrays.sort(charArray);

		return Arrays.equals(charArray, charArray2);
	}

	public static boolean isAnagram1(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Integer> mp = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
            mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)+1);
		}

		for (int i = 0; i < t.length(); i++) {
           mp.put(t.charAt(i), mp.getOrDefault(t.charAt(i), 0)-1);
		}
		
		for(var count:mp.values()) {
			if(count!=0) {
				return false;
			}
		}

		return true;
	}
	
	public static boolean isAnagram2(String s, String t) {
		 if (s.length() != t.length()) {
		        return false;
		    }
		    int[] table = new int[26];
		    
		    for (int i = 0; i < s.length(); i++) {
		    	
		        table[s.charAt(i) - 'a']++;
		    }
		    
		    for (int i = 0; i < t.length(); i++) {
		        table[t.charAt(i) - 'a']--;

		        if (table[t.charAt(i) - 'a'] < 0) {
		            return false;
		        }
		    }
		    return true;
	}
	

}
