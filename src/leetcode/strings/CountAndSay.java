package leetcode.strings;

public class CountAndSay {

//	        Input: n = 4
//			Output: "1211"
//			Explanation:
//			countAndSay(1) = "1"
//			countAndSay(2) = say "1" = one 1 = "11"
//			countAndSay(3) = say "11" = two 1's = "21"
//			countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
	public static void main(String[] args) {
		String countAndSay = countAndSay(4);
		System.out.println(countAndSay);
	}
	
	  public static String countAndSay(int n) {
		  if(n==1) {
			  return "1";
		  }
		  String ans="1";
		  for(int i=2;i<=n;i++) {
			  ans=f(ans);
		  }
		  
		  return ans;
	  }
	  
	  public static String f(String s) {
		  char ch= s.charAt(0);
		  int count=1;
		  StringBuilder sb=new StringBuilder();
		  
		  for(int i=1;i<s.length();i++) {
			  if(s.charAt(i)!=ch) {
				  sb.append(count).append(ch);
                  ch=s.charAt(i);
                  count=1;
			  }else {
				  count++;
			  }
		  }
		  
		  sb.append(count).append(ch);
		  return sb.toString();
	  }
	  
	  
	  

}
