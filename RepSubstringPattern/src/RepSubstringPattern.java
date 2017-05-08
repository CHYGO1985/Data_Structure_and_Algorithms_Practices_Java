
public class RepSubstringPattern {
	
	public static boolean repeatedSubstringPattern(String s) {
        // idea: use replace() and subSequences, iterate until half of the s, check whether if the result is ""
        // method 1: TLE --> add control (s.len / sub.len == 0) --> 401ms. beat 4%
        
        // method 2: use KMP (did not think about it)
        
        // *** check whether it is a prime number:
        // ref: https://leetcode.com/problems/count-primes/#/description
        // *** Java Language: 1. replace() needs a return value, s = s.replace(), then the val of s can be changed
        // 2. split(), "aaaa" s.split("a") will return empty array []
        
        /*
        if (null == s || 0 == s.length() || 1 == s.length())
            return false;
        
        // int len = (s.length() % 2 == 0) ? (s.length() / 2) : (isPrime(s.length() + 1) ? 1 : (s.length() / 3 + 1));
        int len = (s.length() % 2 == 0) ? (s.length() / 2) : (s.length() / 3 + 1);
        
        // optimise: length = even, odd, prime number?
        for (int i = 1; i <= len; i ++) {
             
            String temp = s;
            // *** add control to solve TLE: if s.len % substring.len = 0, then check
            String pattern = temp.substring(0, i);
            if (s.length() % pattern.length() != 0)
                continue;
                
            temp = temp.replaceAll(pattern, "");
            if (temp.equals(""))
                return true;
            
            // 523ms
            String[] arr = temp.split(pattern);
            if (arr.length == 0)
                return true;
        }
        
        return false;
        */
		
		if (null == s || 0 == s.length() || 1 == s.length())
            return false;
            
        int len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        int suffix = 0;
        int prefix = -1;
        
        while (suffix < len - 1) {
            
            if (prefix == -1 || s.charAt(suffix) == s.charAt(prefix)) {
                suffix ++;
                prefix ++;
                next[suffix] = prefix;
            }
            else {
                // suffix is fixed, and prefix is flexible
                prefix = next[prefix];
            }
        }
        
        return len % (len - 1 - next[len-1]) == 0 ? true : false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab";
		boolean res = repeatedSubstringPattern(s);
		
	}

}
