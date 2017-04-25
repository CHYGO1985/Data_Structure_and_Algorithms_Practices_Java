import java.util.HashMap;
import java.util.Map;


public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        // round 1: *** iterate through a map
        
        // method 2: use set (faster)
        // https://discuss.leetcode.com/topic/22057/java-solution-w-set-one-pass-without-counters
        
        // round 2: try set 
        
        // idea: hashmap, check even occurance of char + 1 odd
        if (null == s) 
            return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        for (int i = 0; i < s.length(); i ++) {
            char temp = s.charAt(i);
            int count = map.getOrDefault(temp, 0);
            map.put(temp, count + 1);
        }
        
        // for (Map.Entry<Character, Integer> entry : map.entrySet())
        int odd = 0;
        for (Character key : map.keySet()) {
            if (map.get(key) % 2 != 0)
                odd ++;
            if (odd >= 2)
                return false;
        }
        return true;
    }
}
