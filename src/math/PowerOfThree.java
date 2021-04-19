package math;

public class PowerOfThree {

	public static void main(String[] args) {

	}

	  public static boolean isPowerOfThree(int n) {
		  if(n<1) {
			  return false;
		  }
		  while(n%3==0) {
			  n/=3;
		  }
		  return n==1;
	  }
	  
	  /*
	   * n=3^i;
	   * i=log3 n
	   * i=logn/log3
	   * 
	   */
	  
	  public boolean isPowerOfThree1(int n) {
		  if (n <= 0) return false;
	        int d = (int)(Math.log10(n)/Math.log10(3));
	        return Math.pow(3, d) == n;
	  }
}
