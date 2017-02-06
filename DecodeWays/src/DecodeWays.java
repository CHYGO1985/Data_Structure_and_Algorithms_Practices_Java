
public class DecodeWays {
	
	public static int numDecodings(String s) {
        // idea: mathematical question
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
        /*
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
        */
		
		if (null == s || 0 == s.length()) {
            return 0;
        }
        
        int[] count = new int[s.length() + 1];
        // when there is 0 char, there is 1 decode way (this is for convinient of the algorithm)
        count[0] = 1;
        // when there is 1 char, there is 1 way
        count[1] = s.charAt(0) != '0' ? 1 : 0;
        // for using i - 2, so i must start from 2
        for (int i = 2; i <= s.length(); i ++) {
            
            int temp = s.charAt(i - 1) - '0';
            if (temp >= 1 && temp <= 9) {
                count[i] += count[i - 1];
            }  
            
            int pair = temp * 10 + (s.charAt(i - 2) - '0');
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
