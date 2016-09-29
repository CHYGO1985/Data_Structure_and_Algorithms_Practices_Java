/*
 * Question:
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
	
	public static String longestCommonPrefix(String[] strs) {
        // * idea: optimise from brutal force -- > Solution 1: search from the longest string to shorter one
        // 1) if there is common prefix A in the longest, and the A.length >= the 2nd longest, then return the A
        // 1.5) else A.length < 2nd longest, find the common prefix which use 2nd longest string as a base, find prefix B
        // 2) if A.len >= B.len, and A.len >= 3rd longest, return A, else, search 3rd
        // 2.5) else A.len < B.len, relace A with B, if B.len >= 3rd longest, return B, else search 3rd
        
        // *** I misunderstood the question, the question implies that all the strings in the array have a common prefix, which means that the longest one must not be longer than the shortest string in the array.
        // ****** solution from: http://www.cnblogs.com/springfor/p/3872316.html
        
        // special case: strs.length == 0 or strs.length == 1
        if (0 == strs.length || null == strs)
            return "";
        
        for(int i = 0; i<strs[0].length(); i++){
            char x = strs[0].charAt(i);
            
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i) != x)
                    return strs[0].substring(0,i);
            }
        }
         
        return strs[0];
        
       
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
