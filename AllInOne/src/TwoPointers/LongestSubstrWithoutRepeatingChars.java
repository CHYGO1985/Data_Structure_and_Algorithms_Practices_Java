/**
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * @author jingjiejiang
 * @history Mar 3, 2021
 * 
 */
public class LongestSubstrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int right = 0, left = 0; right < n; right++) {
            
            char curChar = s.charAt(right);
            
            if (map.containsKey(curChar)) {
                left = Math.max(map.get(curChar), left);

            }
            
            ans = Math.max(ans, right - left + 1);
            
            // "tmmzuxt": when we got repeat t, in this case we should not update the left pointer
            // but it we put ++ in if condition, the left pointer will be moved + 1,  then we got 4 instead of 5
            map.put(scurChar, right + 1);
        }
        
        return ans;
    }
}
