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
        
        if (null == s || 0 == s.length())
            return 0;
            
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 1;
        int matchPoint = 0;
        for (int i = 0; i < s.length(); i ++) {
             
             char temp = s.charAt(i);
             if (map.getOrDefault(temp, -1) != -1) {
                 matchPoint = Math.max(matchPoint, map.get(s.charAt(i)) + 1);
             }
             map.put(temp, i);
             max = Math.max(max, i - matchPoint + 1);
        } 
        
        return max;
    }
}
