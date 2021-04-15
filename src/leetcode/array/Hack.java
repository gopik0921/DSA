package leetcode.array;

public class Hack {

	public static void main(String[] args) {
      int c=0,a=3;
      while(c++<3) {
    	  int b=(1+2*c)%3;
    	  System.out.println(b);
    	  switch(b) {
    	   default:
    	   case 0: a-=1; break;
    	   case 1: a+=5;
    	  }
      }
      System.out.println(a);
	}

}
