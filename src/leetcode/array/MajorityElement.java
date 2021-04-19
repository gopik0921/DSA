package leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {

	// The majority element is the element that appears more than n / 2 times. You
	// may assume that the majority element always exists in the array.
	public static void main(String[] args) {
		int[] arr = new int[] { 3,2,3,2,2,3,4};
		majorityElement1(arr);
	}

	public static int majorityElement(int[] nums) {

//		Arrays.sort(nums);
//		return nums[nums.length / 2];

		Map<Integer, Integer> mp = new HashMap<>();
		for (int i : nums) {

			mp.put(i, mp.getOrDefault(i, 0) + 1);

		}

		for (Entry<Integer, Integer> e : mp.entrySet()) {
			if (e.getValue() > nums.length / 2) {
				return e.getKey();
			}
		}
		return -1;
	}

	// Boyer-Moore Voting Algorithm O(n) O(1)
	public static int majorityElement1(int[] nums) {
		int count = 0;
		int candidate = 0;
		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (candidate == num) ? 1 : -1;
		}
		System.out.println(candidate);
		return candidate;
	}

}
