
public class LicenseKeyFormatting {
	
	public String licenseKeyFormatting(String S, int K) {
        // idea: split the string and then check the substring one by one
        // *** substring(), endindex is not included
        /*
        for each String, consider the case of str.length >K, =K, <K, then repeat the process for the rest of the string
        */
        
        // round 1: used 1 hour, things learned
        // *** I did not thing about "aaaa" as a testcase
        // *** i did not think "--a-a-a-a--" as a testcase
        // *** String: replaceAll()
        // *** Java Regular Expression
        // Process: think about solution for a normal case, then try the solution with different test case in mind 
        
        /*
        if (S == null || S.length() == 0) {
            return S;
        }
        
        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder builder = new StringBuilder();
        int curLen = K;
 
        while (S.length() != 0) {
            int len = S.length();
            if (len < curLen) {
                curLen = curLen - len;
                builder.insert(0, S);
                S = S.substring(0, 0);
            }
            // temp.length() >= curLen
            else {
                builder.insert(0, S.substring(len - curLen, len));
                S = S.substring(0, len - curLen);
                // *** I forgot to handle it is the last one, "-" should not be added
                if (S.length() != 0)
                    builder.insert(0, "-");
                curLen = K;
            }
        }
        
        return builder.toString();
        */
        // Method 2: https://discuss.leetcode.com/topic/75225/java-easy-to-understand-solution/2
        S = S.replaceAll("[-]", "");
        S = S.toUpperCase();
    
        StringBuilder sb = new StringBuilder();
        sb.append(S);
    
        int i=sb.length()-K;
        while(i>0) {
            sb.insert(i, '-');
            i = i-K;
        }
    
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
