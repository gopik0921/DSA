package leetcode.array;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
public class TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 7, 11, 15 };
		int target = 26;
		int[] twoSum = twoSum1(nums, target);
		for (int i : twoSum) {
			System.out.print(i);
		}
	}

	//O(n^2) O(1)
	public static int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					arr[0] = i;
					arr[1] = j;
					break;
				}
			}
		}

		return arr;
	}
	
	//O(n) O(n)
	public static int[] twoSum1(int[] nums, int target) {
		
		  Map<Integer, Integer> map = new HashMap<>();
		    for (int i = 0; i < nums.length; i++) {
		        int complement = target - nums[i];
		        if (map.containsKey(complement)) {
		            return new int[] { map.get(complement), i };
		        }
		        map.put(nums[i], i);
		    }
		    throw new IllegalArgumentException("No two sum solution");
	}

		

}
