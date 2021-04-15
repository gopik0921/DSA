package leetcode.strings;

public class StringToInteger {
    //*****//
	public static void main(String[] args) {
		int myAtoi = myAtoi("  -91283472332w");
		System.out.println(myAtoi);
	}

	public static int myAtoi(String str) {
		int sign = 0;
		int leadingZeros = 0;
		double sum = 0;
		str=str.trim();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			 if (c == '-' && sum == 0 && sign == 0 && leadingZeros == 0) {
				sign = -1;
			} else if (c == '+' && sum == 0 && sign == 0 && leadingZeros == 0) {
				sign = 1;
			} else if (c >= '0' && c <= '9') {
				sum = sum * 10 + (c - '0');
				if (sum == 0) {
					leadingZeros++;
				} else if (sum > Integer.MAX_VALUE) {
					return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
				}
			} else {
				return sign == -1 ? sign * ((int) sum) : (int) sum;
			}
		}

		return sign == -1 ? sign * ((int) sum) : (int) sum;
	}

}
