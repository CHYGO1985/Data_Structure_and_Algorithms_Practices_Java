
/**
 * 
 * round 1: 5 hours, solved, 2 dimensional dp, 300ms
 * idea: 1. brutal force. first find out there is no math solution so it is a recursive dp.
 * I first tried brutal force, construct all the substrings as : "a-b-3"
 * start char - end char - length. add it to the set, then check the length of
 * the set.
 * 
 * 2. dp + hashset. The problem of brutal force obviously is TLE. so i think about use 
 * dp + hashset to avoid checking repeated substrings. The idea is:
 * dp[startChar][endChar(int value)] = length of the sub string.
 * e.g. abc abcabc
 * first abc, then dp[0][2] = 2 - 0 = 2
 * second abcabc, coz 6 - 1 = 5 > dp[0][2] (3), so update dp[0][2] = 5
 * otherwise, if <= dp[startChar][endChar], then it means we have already
 * examine the sub string. e.g. abcabc -> dp[0][2] = 5,
 * then if abc, 2 < dp[0][2], means abc has already counted
 * 
 * 3. only dp. from previous method, i further think about whether it is possible to 
 * avoid using hashset. coz the question only ask the number of substring not the 
 * exact substring. so i think according to the feature
 * a b c d
 * from end to start cb cba get two new substrings,
 * d: cd bcd abcd 
 * so the regulation is from end to start, the new substrings num to (i - 1)
 * and i can use dp[startchar][endchar] to check whether the new substring has been
 * counted.
 * so there comes the method 3, get rid of hashset, use only dp.
 * if new substring has a value in dp, then skip, otherwise, go inside to count the
 * new substrings.
 * 
 * 4. *** 2 dimensional substring to 1 dimensional substring. get rid of star char, only count
 * end char.
 * The regulation is:
 * for every char in a continuous increasing string, "abcd", the max num of substrings of 
 * involved end char, is the pos that end char at in the increasing string.
 * e.g. c is at 3, so substring end with c is abc, bc c.
 * d is at 4, so substrings end with d is abcd, bcd, cd, d
 * 
 * then we consider repeated situation: abcdabcd, for repeated d, we just update the num of
 * substrings end with d with is 8 for abcdabcd. dp['d' - 'a'] = max(8, dp['d' - 'a'])
 * Here is the reason why we can use dp only with end char.
 * ref: https://discuss.leetcode.com/topic/70658/concise-java-solution-using-dp/2
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 15, 2017
 */
public class UniqueSubstrInWrapString {
	
	// ref: https://discuss.leetcode.com/topic/70658/concise-java-solution-using-dp/2
	public static int findSubstringInWraproundString(String p) {
        
        if (null == p || 0 == p.length()) return 0;
        int[] dp = new int[26];
        int sum = 0;
        int maxLen = 1;
        
        for (int i = 0; i < p.length(); i ++) {
            
            int index = p.charAt(i) - 'a';
            dp[index] = Math.max(dp[index], maxLen);
            
            if (i + 1 < p.length() && ((index + 1) % 26 == (p.charAt(i + 1) - 'a')))
                maxLen ++;
            else 
                maxLen = 1;
        }
        
        for (int i = 0; i < 26; i ++)
            sum += dp[i];
        
        return sum;
    }

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
	
	/*
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
                if ( (end - start) > dp[tempStart][tempEnd]) {
                    sum += countString(start, end, p, dp);
                }
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
    */
    
    public static void main(String[] args) {
    	findSubstringInWraproundString("abcd");
    }
}
