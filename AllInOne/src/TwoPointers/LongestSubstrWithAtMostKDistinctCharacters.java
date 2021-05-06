import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 340. Longest Substring with At Most K Distinct Characters
 * 
 * @author jingjiejiang
 * @history May 6, 2021
 * 
 */
public class LongestSubstrWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        assert s != null && s.length() >= 1;

        int len = s.length();
        if (k == 0) return 0;

        int left = 0, right = 0;
        int maxLen = 0;
        Map<Character, Integer> charPosMap = new HashMap<>();

        for (; right < len; right ++) {
            
            charPosMap.put(s.charAt(right), right);

            if (charPosMap.size() == k + 1) {

                int minPos = Collections.min(charPosMap.values());
                charPosMap.remove(s.charAt(minPos));

                left = minPos + 1;
            }

            // we do not + 1 here, as right has already + 1 after putting char in hash map
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
