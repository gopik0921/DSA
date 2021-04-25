package leetcode.array;

import java.util.Arrays;

public class MaxInArray {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 2, 12,12, 8,8, 3, 5, 5, 7, 4, }; // duplicates are there
		System.out.println(firstMax(arr));
		System.out.println(secondMax(arr));
		System.out.println(thirdMax(arr));
	}

	public static int firstMax(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > max) {
				max = nums[i];
			}
		}
		return max;
	}

	public static int secondMax(int[] nums) {
		Arrays.sort(nums);
		 int firstmax=nums[nums.length-1];
		int secondMax = Integer.MIN_VALUE;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (secondMax == Integer.MIN_VALUE && nums[i] < firstmax) {
				secondMax = nums[i];
				break;
			}
		}
		return secondMax;
	}

	public static int thirdMax(int[] nums) {
		Arrays.sort(nums);
		int max;
		int secondMax = Integer.MIN_VALUE;
		if (nums == null)
			return 0;
		
		if (nums.length <= 2)
			return nums[nums.length - 1];
		else {
			max = nums[nums.length - 1];
			for (int i = nums.length - 2; i >= 0; i--) {
				if (secondMax == Integer.MIN_VALUE && nums[i] < max) {
					secondMax = nums[i];
					continue;
				}
				if(nums[i]<secondMax)
					return nums[i];
			}
		}
		return max;
	}

}
