package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class ClimbingStairs {

	// You are climbing a staircase. It takes n steps to reach the top.

	// Each time you can either climb 1 or 2 steps. In how many distinct ways can
	// you climb to the top?

	public static void main(String[] args) {
		// climbStairs(6);
		// fibonacci(4);
		
		 Set<Integer> set=new TreeSet<>();
		 set.add(10);
		 set.add(9);
		 System.out.println(set);
	}
	
	

	public static int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public static int fibonacci(int n) {
		List<String> l = new ArrayList<>();
		Collections.reverse(l);
		int[] arr = new int[n + 1];
		arr[0] = 1;
		arr[1] = 2;
		for (int i = 2; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[n]);
		return arr[n];

	}

	// no of 1 bits in the integer
	public int hammingWeight(int n) {
		int sum = 0;
		while (n != 0) {
			sum++;
			n &= (n - 1);
		}
		return sum;
	}

	// no of bits where bits are different in given two integers
	public int hammingDistance(int x, int y) {
		int ans = x ^ y;
		int setbits = 0;
		while (ans > 0) {
			ans = ans & (ans - 1);
			setbits++;
		}
		return setbits;
	}

	Map<Character, Character> mp = new HashMap<>();

	public ClimbingStairs() { // take closings as keys
		mp.put(')', '(');
		mp.put('}', '{');
		mp.put(']', '[');
	}

	// valid Paranthasies
	public boolean isValid(String s) {
		// Initialize a stack to be used in the algorithm.
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// If the current character is a closing bracket.
			if (mp.containsKey(c)) {
				// Get the top element of the stack. If the stack is empty, set a dummy value of
				// '#'
				char topElement = stack.isEmpty() ? '#' : stack.pop();

				// If the mapping for this bracket doesn't match the stack's top element, return
				// false.
				if (topElement != mp.get(c)) {
					return false;
				}

			} else {
				// If it was an opening bracket, push to the stack.
				stack.push(c);
			}
		}

		// If the stack still contains elements, then it is an invalid expression.
		return stack.isEmpty();
	}
}
