package leetcode.array;

public class BuyAndSellStock {

//	You are given an array prices where prices[i] is the price of a given stock on the ith day.
//
//	Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
//
//	Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).( buy buy sell sell not posible)
//	
//   [7,1,5,7,6,4] --- 6  decreasing order no maximum profit
	public static void main(String[] args) {
		
		int[] prices=new int[]{7,1,5,7,6,4};
		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
		
	}
	
	public static int maxProfit(int[] prices) {
		int lowest=prices[0];
		int profit=0;
		
		for(int i=0;i<prices.length;i++) {
			if(prices[i]>lowest) {
				profit+=Math.max(0, prices[i]-lowest);
			}
			lowest=prices[i];
		}
		
		return profit;
	}

}
