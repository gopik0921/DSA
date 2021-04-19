package leetcode.array;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
       
		int[] arr=new int[]{1,4,7,3,54,45,67,9};
		boolean binarySearch = binarySearch(arr,14);
		System.out.println(binarySearch);
		
	}
	

	
	//O(log n) 
	public static boolean binarySearch(int[] arr,int num) {
		Arrays.sort(arr);
		int left=0;
		int right=arr.length-1;
		while(left<right) {
			int mid = left+(right-left)/2; // mid calculation
			if(arr[mid]==num) {
				return true;
			}else if(arr[mid]<num) {
				left=mid+1;
			}else {
				right=mid;
			}
		}
		return false;
	}

}
