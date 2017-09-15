import java.util.HashSet;
import java.util.Set;

/**
 * 
 * round 1: 
 * 
 * idea: dp + hashmap
 * method 1: used only hashset, tle 12/81
 * 
 * method 2: dp + hashset, to prevent count repeated string in p, 79/81
 * 
 * method 3: only dp array, 300ms
 * 
 * method 4
 * 
 * @author jingjiejiang
 *
 */
public class UniqueSubstrInWrapString {

	// method 2: dp + hashset
	/*
	public static int findSubstringInWraproundString(String p) {
        
        if (null == p || 0 == p.length()) return 0;
        
        Set<String> set = new HashSet<>();
        // *** store checked string abc : 0 - 2 : 3
        int[][] dp = new int[26][26];
        int sum = 0;
        
        // iterate through p to find the increasing strings
        int start = 0;
        int end = 0;
        for (int i = 0; i < p.length(); i ++) {
        
            String temp = "" + p.charAt(i);
            if (set.contains(temp) == false) set.add(temp);
            if ( i + 1 < p.length() && ((p.charAt(i) - 'a' + 1) % 26 == (p.charAt(i + 1) - 'a')) ) 
                end ++;
            else {
                // iterate through the strings to cal the dif substrings
                // use haspmap to prevent counting repeating string
                // "start-end-len : count"
                int tempStart = p.charAt(start) - 'a';
                int tempEnd = p.charAt(end) - 'a';
                if ( (end - start) > dp[tempStart][tempEnd])
                // dp[tempStart][tempEnd] = end - start;
                	countString(start, end, set, p, dp);
                start = i + 1;
                end = start;
            }
        }
        
        // *** did not consider case : "a" or last char in the p
        // set.add(p.charAt(p.length() - 1) + "");
        
        if (start < p.length() && end < p.length())
            countString(start, end, set, p, dp);
        
        return set.size();
    }
    
    private static void countString(int start, int end, Set<String> set, String p, int[][] dp) {
        
        if (start == end) return ;
        int shift = start + 1;
        
        while (shift <= end) {
            
            StringBuilder builder = new StringBuilder();
            int reverse = shift - 1;
            while (reverse >= start) {
                int subBegin = p.charAt(reverse) - 'a';
                int subEnd = p.charAt(shift) - 'a'; 
                if (shift - reverse > dp[subBegin][subEnd]) {
                    dp[subBegin][subEnd] = shift - reverse;
                    char rearChar = p.charAt(shift);
                    char frontChar = p.charAt(reverse);
                    int length = shift - reverse + 1;
                    String key = builder.append(frontChar).append("-")
                        .append(rearChar).append("-").append(length).toString();
                    if (set.contains(key) == false) set.add(key);
                }
                reverse --;
            }
            shift ++;
        }
    }
    */
	
    public static int findSubstringInWraproundString(String p) {
        
        if (null == p || 0 == p.length()) return 0;
        
        // *** store checked string abc : 0 - 2 : 3
        int[][] dp = new int[26][26];
        // for fill single char in the dp array
        for (int i = 0; i < 26; i ++) dp[i][i] = -1;
        int sum = 0;
        
        // iterate through p to find the increasing strings
        int start = 0;
        int end = 0;
        
        System.out.println(p.charAt(26));
        System.out.println(p.charAt(27));
        
        for (int i = 0; i < p.length(); i ++) {
        
            int temp = p.charAt(i) - 'a';
            //*** the thing is temp - temp may also means a string abca, 
            // so should use == -1 as a condition
            if (dp[temp][temp] == -1) {
                dp[temp][temp] = temp;
                sum ++;
            }
            
            if ( i + 1 < p.length() && ((p.charAt(i) - 'a' + 1) % 26 == (p.charAt(i + 1) - 'a')) ) 
                end ++;
            else {
                // iterate through the strings to cal the dif substrings
                // use haspmap to prevent counting repeating string
                int tempStart = p.charAt(start) - 'a';
                int tempEnd = p.charAt(end) - 'a';
                if ( (end - start) > dp[tempStart][tempEnd]) 
                    sum += countString(start, end, p, dp);
                start = i + 1;
                end = start;
            }
        }
        
        return sum;
    }
    
    private static int countString(int start, int end, String p, int[][] dp) {
        
        int shift = start + 1;
        int count = 0;
        
        // when start == end, quit directly
        while (shift < end) {
            
            int reverse = shift - 1;
            while (reverse >= start) {
                int subBegin = p.charAt(reverse) - 'a';
                int subEnd = p.charAt(shift) - 'a'; 
                if (shift - reverse > dp[subBegin][subEnd]) {
                    dp[subBegin][subEnd] = shift - reverse;
                    count ++;
                }
                reverse --;
            }
            shift ++;
        }
        return count;
    }
    
    public static void main(String[] args) {
    	findSubstringInWraproundString("rstuvwxyzabcdefghijklmnopqrcdefghijklmnopqr");
    }
}
