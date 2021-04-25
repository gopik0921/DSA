package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSubArray {
//Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
	public static void main(String[] args) {

	}
	 public static int maxSubArray(int[] nums) {
		 
		 int maxSum=nums[0],currentMax=nums[0];
		 for(int i=1;i<nums.length;i++) {
			 currentMax=Math.max(nums[i], currentMax+nums[i]);
			 maxSum=Math.max(currentMax, maxSum);
		 }
		 return maxSum;
		 
	 }
}


