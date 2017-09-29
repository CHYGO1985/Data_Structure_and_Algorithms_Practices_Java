/**
 * 
 * 567. Permutation in String
 * 
 * round 1: 30 minutes, solved, 3 attemps.
 * idea: find match --> hash map
 * s2 find a substring  that match s1: sliding window
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 29, 2017
 */
public class PermutationInString {
	
	public boolean checkInclusion(String s1, String s2) {
	    
        // put chars in s1 in a hashmap 
        // check s2 by the length of s1, if char matches in hash map, count + 1
        // if count == s1.length in the sliding window, return true
        
        if (null == s2 || 0 == s2.length()) return false;
        
        int[] arr = new int[26];
        
        for (int i = 0; i < s1.length(); i ++)
            arr[s1.charAt(i) - 'a'] ++;
        
        int window = s1.length();
        
        //*** used < here at first, instead of <=
        for (int i = 0; i + window <= s2.length(); i ++) {
            int[] copyArr = arr.clone();
            int shift = i;
            int count = 0;
            
            while (shift < i + window) {
                
                // *** used charAt(i)
                int index = s2.charAt(shift) - 'a';
                if (copyArr[index] <= 0) break;
                copyArr[index] --;
                count ++;
                shift ++;
            }
            
            if (count == s1.length()) return true;
        }
        
        return false;
    }
}
