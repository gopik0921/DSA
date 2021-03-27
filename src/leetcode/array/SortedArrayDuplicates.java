package leetcode.array;

public class SortedArrayDuplicates {

	// [1,1,2,2,2,4,7] --> [1,2,4,7] length 4 O(N) O(1)
	public static void main(String[] args) {
       int[] array=new int[] {1,1,2,2,2,4,7};
       int n=removeDuplicates(array);
       System.out.println(n);
	}
	
	   public static int removeDuplicates(int[] nums) {
	        int n=nums.length;
	         if (n == 0 || n == 1)
	            return n;
	         
	        int j = 0;
	          for (int i = 0; i < n-1; i++){
	            if (nums[i] != nums[i+1]){
	                   nums[j++] = nums[i]; 
	            }
	          }
	            
	       
	        nums[j++] = nums[n-1];
	        
	        return j;
	    }

}
