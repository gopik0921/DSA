package leetcode.strings;

public class ReverseString {

	public static void main(String[] args) {
		//String reverse = reverse("Hello");
		//System.out.println(reverse);
		reverse1("Hello");
	}

	public static String reverse(String s) {
		char[] arr = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; i--) {
			sb.append(arr[i]);
		}
		return sb.toString();
	}

	public static void reverse1(String str) {
		if ((str == null) || (str.length() <= 1))
			System.out.println(str);
		else {
			System.out.print(str.charAt(str.length() - 1));
			reverse1(str.substring(0, str.length() - 1));
		}
	}
}
