package dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClimbingStairs {

	//You are climbing a staircase. It takes n steps to reach the top.

	//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
	
	public static void main(String[] args) {
		//climbStairs(6);
		fibonacci(4);
	}

	  public static int climbStairs(int n) {
		  if(n==1) {
			  return 1;
		  }
		  int[] dp=new int[n+1];
		  dp[1]=1;
		  dp[2]=2;
		  for(int i=3;i<=n;i++) {
			  dp[i]=dp[i-1]+dp[i-2];
		  }
		  return dp[n];
	  }
	  
	  public static int fibonacci(int n) {
		  List<String> l=new ArrayList<>();
		  Collections.reverse(l);
		  int[] arr=new int[n+1];
		  arr[0]=1;
		  arr[1]=2;
		  for(int i=2;i<=n;i++) {
			  arr[i]=arr[i-1]+arr[i-2];
		  }
		  System.out.println(arr[n]);
		  return arr[n];
		  
	  }
}
