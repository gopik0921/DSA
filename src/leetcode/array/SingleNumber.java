package leetcode.array;

public class SingleNumber {
	//Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
	//[4,1,2,1,2] -- 4
	public static void main(String[] args) {
		int[] nums=new int[]{4,1,2,1,2};
		int singleNumber = singleNumber(nums);
		System.out.println(singleNumber);
		}
	//O(n) O(1)
	   public static int singleNumber(int[] nums) {
	        int a = 0;
	    for (int i : nums) {
	      a ^= i;
	    }
	    return a;
	    }
	   
//
//If we take XOR of zero and some bit, it will return that bit
//a⊕0=a
//If we take XOR of two same bits, it will return 0
//a⊕a=0
//a⊕b⊕a=(a⊕a)⊕b=0⊕b=b
//So we can XOR all bits together to find the unique number.
}
