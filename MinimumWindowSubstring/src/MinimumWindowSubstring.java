/**
 * 
 * 567. Permutation in String
 * 
 * round 1: unsolved, 2 hours
 * ref: https://discuss.leetcode.com/topic/21143/java-solution-using-two-pointers-hashmap
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep, 28, 2017
 */
public class MinimumWindowSubstring {
	
	// unvalid solution (TLE)
	public static String minWindow(String s, String t) {
        
        if (null == t || 0 == t.length()) return "";
        
        // strong char in s in hashmap
        // 122 - 65 + 1 = 58
        int[] chars = new int[58];
        
        for (int i = 0; i < t.length(); i ++)
            chars[t.charAt(i) - 'A'] ++;
        
        // for case "a"
        int[] pos = new int[s.length() + 1];
        // record all avail char (char in s) in t (next avail pos)
        int prePos = 0;
        pos[0] = -1;
        for (int i = 0; i < s.length(); i ++)
            if (chars[s.charAt(i) - 'A'] > 0) {
                pos[prePos] = i;
                prePos = i == prePos ? i + 1: i;
            }
        
        // the last one
        if (prePos >= 0) pos[prePos] = -1;
        
        // iterate through t, if find a match, then compare with current min len
        // start with next avail char until the end
        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        int start = pos[0];
        while (start != -1) {
            
            int[] charsCopy = chars.clone();
            int shift = start;
            int count = 0;

            // problem here : if pos[shift] == -1 is the last one, we still need to check here
            while (shift != -1 && count < t.length()) {
                if (charsCopy[s.charAt(shift) - 'A'] > 0) {
                	charsCopy[s.charAt(shift) - 'A'] --;
                	count ++;
                }
                
                if (count < t.length())
                	shift = shift == pos[shift]? pos[shift + 1]: pos[shift];
            } 

            if (count == t.length()) {
                // if current match length < previous min substring
                if (shift - start + 1 < res[0]) {
                    res[0] = shift - start + 1;
                    res[1] = start;
                }
            }
            else
                break;

            // coz i need to ++, so -1
            start = start == pos[start]? pos[start + 1]: pos[start];
        }
        
        return res[0] == Integer.MAX_VALUE ? "" : s.substring(res[1], res[0] + res[1]);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String  res  = minWindow("ADOBECODEBANC", "ABC");
		// String  res  = minWindow("aa", "aa");
		String  res  = minWindow("bba", "ab");
		System.out.print(res);
	}

}
