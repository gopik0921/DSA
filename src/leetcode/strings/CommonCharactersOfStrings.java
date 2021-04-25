package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class CommonCharactersOfStrings {

	public static void main(String[] args) {
		common("geekforgeeks", "leetseeks");
	}

	static int MAX_CHAR = 26;

	public static List<Character> common(String s1, String s2) {
		List<Character> list = new ArrayList<>();

		int[] arr1 = new int[MAX_CHAR];
		int[] arr2 = new int[MAX_CHAR];

		for (int i = 0; i < s1.length(); i++)
			arr1[s1.charAt(i) - 'a']++;

		for (int i = 0; i < s2.length(); i++)
			arr2[s2.charAt(i) - 'a']++;

		for (int i = 0; i < MAX_CHAR; i++) {
			if (arr1[i] != 0 && arr2[i] != 0) {
				for (int j = 0; j < Math.min(arr1[i], arr2[i]); j++) {
					list.add((char) (i + 'a'));
				}
			}
		}

		System.out.print(list);
		return list;
	}

}
