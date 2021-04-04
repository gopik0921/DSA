package leetcode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {

	// Given an integer array nums, return true if any value appears at least twice
	// in the array, and return false if every element is distinct.

	// nums = [1,2,3,1] -- true
	// nums = [1,2,3,4] -- false
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4 };
		boolean b = containsDuplicate2(nums);
		System.out.println(b);
	}

	// O(nlogn) O(1)
	public static boolean containsDuplicate1(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 1; ++i) {
			if (nums[i] == nums[i + 1])
				return true;
		}
		return false;
	}

	// O(n^2) O(1)
	public static boolean containsDuplicate2(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// O(n) O(n)
	public boolean containsDuplicate3(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int x : nums) {
			if (set.contains(x))
				return true;
			set.add(x);
		}
		return false;
	}

}
