package leetcode.array;

public class RotateArray {
	// Given an array, rotate the array to the right by k steps, where k is
	// non-negative.

	// Input: nums = [1,2,3,4,5,6,7], k = 3
	// Output: [5,6,7,1,2,3,4]
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate3(nums, 3);
		print(nums);
	}

	private static void print(int[] nums) {
		for (int i : nums) {
			System.out.print(i);
		}
	}

	// O(n*k) O(1)
	public static void rotate1(int[] nums, int k) {

		k %= nums.length;
		int previous = 0;
		int temp = 0;
		for (int i = 0; i < k; i++) {
			previous = nums[nums.length - 1]; // p=4 p=3
			for (int j = 0; j < nums.length; j++) {
				temp = nums[j]; // t=1 t=2 t=3 t=4 t=4 t= 1 t=2 t=3
				nums[j] = previous; // 4 2 3 4 -- 4 1 3 4 -- 4 1 2 4 -- 4 1 2 3 -- 3 1 2 3 -- 3 4 2 3 -- 3 4 1 3 --
									// 3 4 1 2
				previous = temp; // p=1 p=2 p=3 p=4 p=4 p=1 p=2 p=3
			}
		}

	}

	// O(n) O(n)
	public static void rotate2(int[] nums, int k) {
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i]; // (i+K)%nums.length -- gives rearanged position
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = a[i];
		}

	}

	// O(n) O(1)
	// Original List : 1 2 3 4 5 6 7
	public static void rotate3(int[] nums, int k) {
		reverse(nums, 0, nums.length - 1); // After reversing all numbers : 7 6 5 4 3 2 1
		reverse(nums, 0, k - 1); // After reversing first k numbers : 5 6 7 4 3 2 1
		reverse(nums, k, nums.length - 1); // After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

}
