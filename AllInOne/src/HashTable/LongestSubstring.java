package src.HashTable;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public int lengthOfLongestSubstring(String s) {
        // *** test case: "dvdf" -- record index info
        // method 1: O(n^2), TLE error
        // *** the hardest part is, e.g."tmmzuxt", skip the letters before the first match "m"
        // 1) I was thinking to update map (which lean to O(n^2)) solution
        
        // method 2: use a match point to record the last MAX match point
        // ref: https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation
        
        assert s != null && s.length() >= 0;
        
        Map<Character, Integer> charIdxMap = new HashMap<>();
        int matchPoint = 0;
        int maxLen = 0;
        
        for (int idx = 0; idx < s.length(); idx ++) {
            
            char curChar = s.charAt(idx);
            if (charIdxMap.getOrDefault(curChar, -1 ) != -1) {
                matchPoint = Math.max(matchPoint, charIdxMap.get(curChar) + 1);
            }
            
            charIdxMap.put(curChar, idx);
            maxLen = Math.max(maxLen, idx - matchPoint + 1);
        }
        
        return maxLen;
    }
}
