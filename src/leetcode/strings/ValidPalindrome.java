package leetcode.strings;


public class ValidPalindrome {

	public static void main(String[] args) {
		boolean palindrome = isPalindrome1("A man, a plan, a canal: Panama");
		System.out.println(palindrome);
	}
	
	 public static boolean isPalindrome(String s) {
		   s=s.replaceAll("[^a-zA-Z0-9]", "");
		   StringBuilder sb=new StringBuilder();
		    for(int i=s.length()-1;i>=0;i--) {
		    	sb.append(s.charAt(i));
		    }
	        return sb.toString().equalsIgnoreCase(s);
	    }
	 
	 public static boolean isPalindrome1(String s) {
		   s=s.toLowerCase();
		   s=s.replaceAll("[^a-zA-Z0-9]", "");
		   boolean result=true;
		   int start=0;
		   int end =s.length()-1;
		   while(start<end) {
			   if(s.charAt(start)!=s.charAt(end)) {
				   result=false;
				   break;
			   }
			   start++;
			   end--;
		   }
		  return result;
	    }

}
