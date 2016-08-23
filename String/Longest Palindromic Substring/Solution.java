// LeetCode, Longest Palindromic Substring
// Time complexity O(n^2)
public class Solution {
    int start = 0;
    int end = 0;
    int max = 0;
    public String longestPalindrome(String s) {
		if(s == null) return null;
		if(s.length() <= 1) return s;
		int len = s.length();
		int middle = (len + 1) / 2 - 1;
		boolean isOdd = len % 2 == 0 ? false : true;
		int left = middle;
		int right = isOdd? middle : middle + 1;

		for(int i = middle; i >= max/2; i--, left--,right++) {
		    count(s, left, left);
		    count(s, left-1,left);
		    
		    count(s,right, right);
		    count(s,right-1,right);
		}
		return s.substring(start, end + 1);
	}
	
	public void count(String s, int left, int right)
	{
	    int len = s.length();
	    if(left < 0 ||s.charAt(left) != s.charAt(right))
	        return;
	        
	    while(left - 1 >=0 && right + 1 < len && s.charAt(left - 1) == s.charAt(right + 1))
	    {
	        left--;
	        right++;
	    }
	    
		if(right - left + 1 > max)
		{
		    max = right - left + 1;
		    start = left;
		    end = right;
		}
    }
}