package leetcode.strings;


//Write a function to find the longest common prefix string amongst an array of strings.

//If there is no common prefix, return an empty string "".
//Input: strs = ["flower","flow","flight"]
//Output: "fl"
public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] strs = new String[] { "ab", "a" };
		String longestCommonPrefix = longestCommonPrefix(strs);
		System.out.println(longestCommonPrefix);
		
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		
		String s1 = strs[0];
		String s2 = strs[1];
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while (i < s1.length() && i < s2.length()) {
			if (s1.charAt(i) == s2.charAt(i)) {
				sb.append(s1.charAt(i));
				i++;
			} else {
				break;
			}
		}

		String pre = sb.toString();
		sb.delete(0, pre.length());
		
		if (pre.equals("")) {
			return "";
		}

		for (int j = 2; j < strs.length; j++) {
			i = 0;
			while (i < pre.length() && i < strs[j].length()) {
				if (pre.charAt(i) == strs[j].charAt(i)) {
					sb.append(pre.charAt(i));
					i++;
				} else {
					break;
				}
			}
			pre = sb.toString();
			if (pre.equals("")) {
				return "";
			}
			sb.delete(0, pre.length());
		}

		return pre;
	}
	
	public String longestCommonPrefix1(String[] strs) {
	    if (strs.length == 0) return "";
	    String prefix = strs[0];
	    for (int i = 1; i < strs.length; i++) {
	        while (strs[i].indexOf(prefix) != 0) {
	            prefix = prefix.substring(0, prefix.length() - 1);
	            if (prefix.isEmpty()) return "";
	        }
	    }
	    return prefix;
	}
}
