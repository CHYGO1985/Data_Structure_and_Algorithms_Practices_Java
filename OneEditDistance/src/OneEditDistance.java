
public class OneEditDistance {

	public boolean isOneEditDistance(String s, String t) {
        // round 1: solved, 1 hour, 2ms, beat 57.29%
        // idea : two pointers tech
        // the definition of edit distance is not clear
        // edit distance: In computer science, edit distance is a way of quantifying how dissimilar two strings
        // (e.g., words) are to one another by counting the minimum number of operations required to transform one
        // string into the other. (position matters)
        
        // idea: hashMap (two difference abc, abd or one difference: abcd, abc)
        // if use set, then abcc, abee --> true
        // test case: 1) two empty strings "" and ""
        // *** "teacher","detacher" --> false (position count)
        
        // method 2: 
        // ref: https://discuss.leetcode.com/topic/30308/my-clear-java-solution-with-explanation
    
        /*
        if ( (null == s && null == t) || s.equals(t) || (Math.abs(s.length() - t.length()) >= 2) )
            return false;
        
        String longStr = s.length() >= t.length() ? s : t;
        String shortStr = s.length() < t.length() ? s : t;
    
        int i = 0, j = 0;
        int dif = 0;
        while (i < longStr.length() && j < shortStr.length()) {
            // refactoring
            if (longStr.charAt(i) != shortStr.charAt(j)) {
                if (s.length() != t.length()) { 
                    j --;
                }
                dif ++;
                if (dif > 1) return false;
            }
            j ++;
            i ++;
        }
        
        while (i < longStr.length()) {
            dif ++;
            if (dif > 1) return false;
            i ++;
        }
        
        return true;
        */
        
        // method 2: analysis the question, get the regulation (without the need to iterate through one by one)
        /*
         * There're 3 possibilities to satisfy one edit distance apart: 
         * 
         * 1) Replace 1 char:
         	  s: a B c
         	  t: a D c
         * 2) Delete 1 char from s: 
        	  s: a D  b c
        	  t: a    b c
         * 3) Delete 1 char from t
        	  s: a   b c
	    */
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) { 
        	if (s.charAt(i) != t.charAt(i)) {
        		if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
        			return s.substring(i + 1).equals(t.substring(i + 1));
    			else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
    				return s.substring(i).equals(t.substring(i + 1));	        	
    			else // s is longer than t, so the only possibility is deleting one char from s
    				return t.substring(i).equals(s.substring(i + 1));
        	}
        }       
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t 
        return Math.abs(s.length() - t.length()) == 1;
    }
	
}
