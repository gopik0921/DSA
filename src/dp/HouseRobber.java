package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobber {

	public static void main(String[] args) throws InterruptedException {

	}

	public static int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);

		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}

}

class A extends B{
	public static void main(String[] args) {
		new A().a();
	}
	void a() {

	 System.out.println(i);
	}
	
 
}

class B{
	 int i=0;
	 B(){
		 i=10;
	 }
	 
	 void c() {
		 
	 }
	 
	 
}

