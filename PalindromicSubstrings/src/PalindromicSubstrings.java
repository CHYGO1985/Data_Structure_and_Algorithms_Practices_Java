/**
 * 
 * 647. Palindromic Substrings
 * 
 * round 1: only traditional method1. start from mid: i,i and i, i + 1. extend 
 * left and right, check the existance of palindrome.
 * ref: https://leetcode.com/problems/palindromic-substrings/#/description
 * 
 * method2: manacher algorithm. for every pos, that has a palindrome length > 1, count + 1
 * final res = length + panlindrome count
 * 
 * method 3: DP (implement later)
 * ref: https://discuss.leetcode.com/topic/96821/java-dp-solution-based-on-longest-palindromic-substring
 *
 * @author jingjiejiang
 * @history 
 * 1. Jul 27, 2017
 */
public class PalindromicSubstrings {
	
	// manacher's algorithm
	/*
    public int countSubstrings(String s) {
        
        int sum = 0;
        
        // boundary case
        if (null == s || 0 == s.length()) return sum;
            
        // extend the s with extra chars for Manacher's algorithm
        char[] extendArr = preProcess(s);    
        
        // Manacher's algorithm to count palindromes 
        int[] indicator = manachers(extendArr);
        
        for (int i : indicator) sum += i / 2;
        
        return sum + s.length();
    }
    
    private char[] preProcess(String s) {
        
        char[] arr = new char[s.length() * 2 + 3];
		
		arr[0] = '@';
		int index = 1;
		for (; index < arr.length - 1; index ++) {
			arr[index] = (index % 2 == 0) ? s.charAt(index / 2 - 1) : '#';
			
		}
		arr[index] = '&';
		return arr;  
    }
    
    private int[] manachers(char[] arr) {
        
        int[] indicator = new int[arr.length];
        indicator[0] = indicator[1] = 0;
            
        int centre = 0;
        int right = 0;
        int mirr = 0;
        
        for (int i = 1; i < arr.length - 1; i ++) {
            
            mirr = 2 * centre - i;
            if (i < right) indicator[i] = Math.min(indicator[mirr], indicator[right - i]);
            while (arr[i + (indicator[i] + 1)] == arr[i - (indicator[i] + 1)])
                indicator[i] ++;
    
            if (i + indicator[i] > right) {
                centre = i;
                right = i + indicator[i];
            } 
        }
        
        return indicator;
    }
    */
    
}
