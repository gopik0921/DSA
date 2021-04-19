package math;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
//	Input: s = "MCMXCIV"
//	Output: 1994
//	Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
	public static void main(String[] args) {

	}

	public int romanToInt(String s) {
		Map<Character, Integer> mp = new HashMap<>();
		preprocessing(mp);
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i < s.length() - 1 && mp.get(s.charAt(i)) < mp.get(s.charAt(i + 1))) {
                result-=mp.get(s.charAt(i));
			} else {
				  result+=mp.get(s.charAt(i));
			}
		}
		return result;
	}

	private void preprocessing(Map<Character, Integer> mp) {
		mp.put('I', 1);
		mp.put('V', 5);
		mp.put('X', 10);
		mp.put('L', 50);
		mp.put('C', 100);
		mp.put('D', 500);
		mp.put('M', 1000);
	}

}
