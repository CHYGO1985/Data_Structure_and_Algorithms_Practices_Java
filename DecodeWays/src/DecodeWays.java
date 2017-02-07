
public class DecodeWays {
	
	public static int numDecodings(String s) {
        // idea: mathematical question --> wrong
        // 1) assume the num of available pair digits in the string s is m (m <= s.length() - 1)
        // 2) from 0 to m pairs are the total number of decode ways
        // 0 --> 2 pairs (all decode as single digit) : use combination formula C(0, m) = 1
        // 1 (i) --> 2 pairs (only one): C(1, m) = m
        // 2 (i) --> 2 pairs: C(2, m) = m(m-1)/2
        // 3 (i) --> 2 pairs: C(3, m) = m(m-1)(m-2)/3
        // until m --> 2 pairs: C(m, m) = 1; 
        // so the formula for each pair num is: m*(m-1)*...*(m-(i-1))/i
        // so I only need to do is to get the avail num of pairs in the String s.
        
        // *** the thing is that: for case like, 1234, 12, 23 cannot be used at the same time, so there won't be C(2, 2)
        // so I need to count available pair that can be used at the some time as well
        
        // idea: DP (from behind)
        // ref: https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanation/2
        // explanation: for every two digits B C ,previous is A, 
        // 1) if they are not two pairs, so which means they can only interpret as single digit, they didn't add any 
        // extra decode way to previous decode way (until B), the decode ways in C is equal to decode ways in B. 
        // 2) if they are valid pair, if BC is a pair, then there is A decode ways, as B, C did not add any new ways;
        // then if B ,C is interpret as single, then there is B decode ways (B = C), so total is A + B decode ways
        // result: 2ms, beat 69.41%
        
        // things learned : 1) substring(start, end) is end index - 1 (The substring begins at the specified beginIndex
        // and extends to the character at index endIndex)
        // 2）very important: always has a computer mind to find a solution, like DP, divide and conquer.
        
        /*
        // ref implementation
        public class Solution {
            public int numDecodings(String s) {
                if(s == null || s.length() == 0) {
                    return 0;
                }
                int n = s.length();
                int[] dp = new int[n+1];
                dp[0] = 1;
                dp[1] = s.charAt(0) != '0' ? 1 : 0;
                for(int i = 2; i <= n; i++) {
                    int first = Integer.valueOf(s.substring(i-1, i));
                    int second = Integer.valueOf(s.substring(i-2, i));
                    if(first >= 1 && first <= 9) {
                       dp[i] += dp[i-1];  
                    }
                    if(second >= 10 && second <= 26) {
                        dp[i] += dp[i-2];
                    }
                }
                return dp[n];
            }
        }
        */
        
        if (null == s || 0 == s.length()) {
            return 0;
        }
        
        int[] count = new int[s.length() + 1];
        // when there is 0 char, there is 1 decode way (this is for convenient of the algorithm)
        count[0] = 1;
        // when there is 1 char, there is 1 way
        count[1] = s.charAt(0) != '0' ? 1 : 0;
        // for using i - 2, so i must start from 2
        for (int i = 2; i <= s.length(); i ++) {
            
            int temp = s.charAt(i - 1) - '0';
            if (temp >= 1 && temp <= 9) {
                count[i] += count[i - 1];
            }  
            
            int pair = (s.charAt(i - 2) - '0') * 10 + temp;
            // when the fist digit is 0, pair can be < 10
            if (pair >= 10 && pair <= 26) {
                count[i] += count[i - 2];
            }
        }
        
        return count[count.length - 1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "123723612";
        
        int num = numDecodings(s);
	}

}
