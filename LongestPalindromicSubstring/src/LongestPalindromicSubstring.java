

public class LongestPalindromicSubstring {
	
	// idea: cannot use any data structure -> recursive 
    // things leard: 1. I was thinking from whole to small (from the whole string to find the palindrome)
    // *** but the solution can be start from palindrome itself, how it is constructed then to whole
    // 2. temp states which cannot be easily return from recursive method, use it as a "global" varible
    
    // method 1:
    // ref: https://discuss.leetcode.com/topic/23498/very-simple-clean-java-solution
    // result: 15ms, beat 97.87%
    private int low = 0;
    private int maxLen = 0;
    
    public String longestPalindrome(String s) {
        
        int len = s.length();
        
        if (null == s || 0 == len || 1 == len) {
            return s;
        }
                
        for (int i = 0; i < len; i ++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        
        return s.substring(low, low + maxLen);
    }
    
    public void checkPalindrome(String s, int begin, int end) {
        
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
        
            begin --;
            end ++;
        }
        
        // it should be (end - 1) - (begin + 1) + 1 = end - begin - 1
        if (maxLen < end - begin - 1) {
            low  = begin + 1;
            maxLen = end - begin - 1;
        }
        
    }
    
    // method 2: from whole string to palindrome
    // method 2: method 2 works, but will exceed time limit
    /*
    private int low = 0;
	private int high = 0;
	private int max = 0;
	
    public String longestPalindrome(String s) {
        
        if (null == s || 0 == s.length() || 1 == s.length()) {
            return s;
        }
        
        char[] arr = s.toCharArray();
        checkPalindrome(arr, 0, s.length() - 1, 0);
        
        return s.substring(low, high + 1);
    }
    
    public void checkPalindrome(char[] arr, int begin, int end, int count) {
    
    	if (begin >= end) {
            return;
        }
    	
        if (arr[begin] == arr[end]) {
        	int tempLow = begin;
        	int tempHigh = end;
            while (begin < end && arr[begin] == arr[end]) {
                begin ++;
                end --;
                count += 2;
            }
            
            count += begin == end? 1 : 0;
            
            if (begin >= end && max < count) {
            	low = tempLow;
            	high = tempHigh;
            	max = count;
            }
            else {
	            begin = tempLow;
	            end = tempHigh;
	            count = 0;
	        }
        }
    	
        // the current length is end - begin + 1, but the next loop the length will - 1
        // so is end - length
        if (max < end - begin) {
            checkPalindrome(arr, begin + 1, end, count);
        }
        
        if (max < end - begin) {
            checkPalindrome(arr, begin, end - 1, count);
        }
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
