package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

	public static void main(String[] args) {
		int[] arr = new int[] { 9, 9 };
		int[] plusOne = plusOne(arr);
		for (int i : plusOne) {
			System.out.print(i);
		}
	}

	public static int[] plusOne(int[] digits) {
		int len = digits.length;
		int plus = 1;
		for (int i = len - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i] += plus;
				plus = 0;
				break;
			}
			digits[i] = 0;
		}
		if (plus == 0)
			return digits;
		int[] newOne = new int[len + 1]; // for all 9s
		newOne[0] = 1;
		return newOne;
	}

//	 long sum=0;
//	   int k=digits.length-1;
//	    for(int i=0;i<digits.length;i++) {
//	    	sum=(long) (sum+(digits[i]*Math.pow(10, k)));
//	    	k--;
//	    }
//	    sum+=1;
//	    List<Integer> list=new ArrayList<>();
//	    char[] chars = Long.toString(sum).toCharArray();
//	    for(char c:chars) {
//	    	int numericValue = Character.getNumericValue(c);
//	    	list.add(numericValue);
//	    }
//	    int[] arr=new int[list.size()];
//	    int index=0;
//	    for(int i:list) {
//	    	arr[index++]=i;
//	    }
//      return arr;

}
