package leetcode.array;

//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
public class MoveZeros {

	public static void main(String[] args) {
		int[] nums=new int[]{0,1,0,3,12};
		moveZeroes1(nums);
		for(int i:nums) {
			System.out.print(i);
		}
	}

	// O(n) O(n)
	public static void moveZeroes(int[] nums) {
		int[] arr = new int[nums.length];
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				arr[index++] = nums[i];
			}
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = arr[i];
		}
	}
	
	//O(n) O(1)
	public static void moveZeroes1(int[] nums) {
		int index=0;
		for(int i:nums) {
			if(i!=0) {
				nums[index++]=i;
			}
		}
		
		while(index<nums.length) {
			nums[index++]=0;
		}
	}

}
