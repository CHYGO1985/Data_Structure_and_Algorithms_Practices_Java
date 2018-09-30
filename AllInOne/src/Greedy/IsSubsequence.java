
public class IsSubsequence {
	
	public static boolean isSubsequence(String s, String t) {
        // *Method 1: idea: two pointers. iterate through s and t at the same time, if find match in t, 
        // tpointer ++ and spointer++, else tpointer ++.
        // * result : solved, 32ms, beat 64.01% in the db, fastest in the db is 3ms.
        // * things learned: indexOf() is much faster than charAt()
        /*
        I checked the origin code of func "indexOf" and "charAt". These two solution both traversed the char of String 
        one by one to search the first occurrence specific char.The difference is that indexOf only call once function 
        then traversed in "String.value[]" arr, but we used multiple calling function "charAt" to get the value in
        "String.value[]" arr. The time expense of calling function made the difference.
        */
        
        
        /*
        int sIndex = 0;
        int tIndex = 0;
        int sLen = s.length();
        int tLen = t.length();
        
        while (sIndex < sLen && tIndex < tLen) {
            
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }    
            tIndex++;
        }
        
        return sIndex >= sLen? true : false;
        */
        
       // Method 2: use queue. http://bookshadow.com/weblog/2016/09/04/leetcode-is-subsequence/
       
       // *** Method 3: use indexOf(int ch, int fromIndex) instead of charAt() : use the fact that match index in t is always
       // larger than index in s.
       // https://discuss.leetcode.com/topic/57205/java-only-2ms-much-faster-than-normal-2-pointers/2
       // result: 2ms, beat 93.54%
       
        if(t.length() < s.length()) return false;
        int prev = 0;
        for(int i = 0; i < s.length();i++)
        {
            char tempChar = s.charAt(i);
            prev = t.indexOf(tempChar,prev);
            if(prev == -1) return false;
            prev++;
        }
        
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
