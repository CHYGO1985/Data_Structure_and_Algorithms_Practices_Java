import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 3. Longest Substring Without Repeating Characters
 * 
 * @author jingjiejiang
 * @history Mar 3, 2021
 * Apr 25, 2022
 * 
 */
public class LongestSubstrWithoutRepeatingChars {
    // public int lengthOfLongestSubstring(String s) {

    //     int n = s.length(), ans = 0;
    //     Map<Character, Integer> map = new HashMap<>(); // current index of character
    //     // try to extend the range [i, j]
    //     for (int right = 0, left = 0; right < n; right++) {
            
    //         char curChar = s.charAt(right);
            
    //         if (map.containsKey(curChar)) {
    //             left = Math.max(map.get(curChar), left);
    //         }
            
    //         // abca: when get a, left is updated to 1, so we need + 1 (right = 3, left = 1)
    //         ans = Math.max(ans, right - left + 1);
            
    //         // "tmmzuxt": when we got repeat t, in this case we should not update the left pointer (as it start with m)
    //         // but it we put ++ in if condition, the left pointer will be moved + 1,  then we got 4 instead of 5
    //         map.put(curChar, right + 1);
    //     }

    //     return ans;
    // }
    
    public int lengthOfLongestSubstring2(String s) {
        
      assert s != null && s.length() >= 0;
      
      Set<Character> charSet = new HashSet<>();
      int maxLen = 0;
      
      for (int left = 0, right = 0; right < s.length(); right ++) {

        char curChar = s.charAt(right);
        if (!charSet.contains(curChar)) {
          charSet.add(curChar);
          maxLen = Math.max(maxLen, charSet.size());
          continue;
        } 

        while (s.charAt(left) != curChar) {
          charSet.remove(s.charAt(left));
          left ++;
        }
        
        // if at the equal pos, still need to add 1 postition
        left ++;
      }

      return maxLen;
    }
}
