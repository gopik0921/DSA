package leetcode.array;

public class Strstr {

	public static void main(String[] args) {
		strStr("hello","pp");
	}
	 public static int strStr(String haystack, String needle) {
	        if(needle.length()==0){
	            return 0;
	        }
	         
	        return haystack.indexOf(needle);
	    }
}
