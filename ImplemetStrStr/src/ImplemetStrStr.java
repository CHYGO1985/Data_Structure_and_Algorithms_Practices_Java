
public class ImplemetStrStr {
	
// **** thins learned: write pseudo code, which will decrease the time spend on a problem.
    
    /*
    public int strStr(String haystack, String needle) {
      for (int i = 0; ; i++) {
        for (int j = 0; ; j++) {
          if (j == needle.length()) return i;
          if (i + j == haystack.length()) return -1;
          if (needle.charAt(j) != haystack.charAt(i + j)) break;
        }
      }
    }
    */
    
    // **** solution: 9ms ***** https://discuss.leetcode.com/topic/41463/java-easy-to-understand-solutions
    // brutal force like algorithm
    /*
    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null)
            return -1;
        int l1 = haystack.length();
        int l2 = needle.length();
        for (int i = 0; i < l1-l2+1; i++) {
            int count = 0;
            while (count < l2 && haystack.charAt(i+count) == needle.charAt(count))
                count++;
            if (count == l2)
                return i;
        }
        return -1;
    }
    */
    
    /*
    public int strStr(String haystack, String needle) {
        // * idea: 1. straight forward solution is to loop through the haystack to check whether it contains needle. use a boolean
        // variable to keep the record of whether the current string have the same char as the needle.
        // for this solution I need to record every single partly matchs
        // 2. how to optimize one? use hashtable, keep the position as value and the int value of the char in needle as key,
        // for every char in haystack, if once there is a match for the first letter, record pos = i, and deudction = i; once the letters after this one does not match then set pos = -1.
        // *Keyword: hashtable to solve match problem.
        // **** remember, when a string str = "", it means it is empty, use str.chatAt(0) will cause problem.
        // **** i didn't know for the special case that haystack ="" or needle = "", the pos = 0.
        // **** I fail to match "mississippi" "issip", a mistach issis contains a match is sip
        
        // *** result of KMP: 12ms, only beat 10 percent
        
        // **** KMP algorithm ****
        
        int stackLen = haystack.length();
        int ndlLen = needle.length();
        
        if (null == haystack || stackLen < ndlLen)
            return -1;
            
        if (haystack.equals("") || needle.equals(""))
            return 0;
        
        int[] next = buildNext(needle, ndlLen);
        int hayIndex = 0;
        int ndlIndex = 0;
        
        while (hayIndex < stackLen) {
            
            // further optimise: http://www.cnblogs.com/dolphin0520/archive/2011/08/24/2151846.html
            // merge the case of ndlIndex = -1 and heyIndex == ndlIndex
            
            if (-1 == ndlIndex || haystack.charAt(hayIndex) == needle.charAt(ndlIndex)) {
                
                hayIndex ++;
                ndlIndex ++;
            }
            else {
                ndlIndex = next[ndlIndex];
            }
            
            // *** i don't understand why not - 1 here? ***
            // coz it plus e already in if
            if (ndlIndex == ndlLen)
                return hayIndex - ndlLen;

            // * optimise the loop, too many if and else
            // 1) reduce the num of variable -- pos can be reduce, cause pos can get by use current index of hay stack - ndlLen
            // 2) if pos is reduced then there is no need to use hasEqual.
        }

        return -1;
    }
    
    public int[] buildNext(String needle, int strSize) {
        
        // ****optimise code to create next function
        // 1) use less variable;
        // 2) optimise logic by the assistant of pseudo code
        int[] next = new int[strSize];
        int frtPos = -1;
        int rearPos = 0;
        
        next[rearPos] = -1;
        
        while (rearPos < strSize - 1) {
            
            if (-1 == frtPos|| needle.charAt(frtPos) == needle.charAt(rearPos)) {
                
                frtPos ++;
                rearPos ++;
                next[rearPos] = frtPos;
                // further optimise for string like aaaaax; 14ms for further optimise
            }
            else {
                
                frtPos = next[frtPos];
            }
        }
        
        return next;
       
    }
    */
    
    // *** 2nd round: implementation of KMP
	
	public static int strStr(String haystack, String needle) {

		// special case: 
		int stackLen = haystack.length();
        int ndlLen = needle.length();
        
        if ( stackLen < ndlLen)
            return -1;
            
        if (true == haystack.isEmpty() || true == needle.isEmpty())
            return 0;
        
        int indexHS = 0;
        int indexND = 0;
        int[] next = buildNext(needle, ndlLen);
        
        while(indexHS < haystack.length()) {
        	
        	if ( -1 == indexND || haystack.charAt(indexHS) == needle.charAt(indexND)) {
        		
        		// can not put here, coz it also handle next[indexND] = -1
        		/*
        		if (indexND == ndlLen - 1) {
        			return indexHS - ndlLen + 1;
        		}
        		*/
        		indexND ++;
        		indexHS ++;
        		
        	}
        	else {
        		indexND = next[indexND];
        	}
        	
        	if (indexND == ndlLen) {
        	    return indexHS - ndlLen;
        	}
        }
        
        return -1;
	}
	
	public static int[] buildNext(String needle, int strSize) {
        
		int[] next = new int[needle.length()];															
        int front = -1;
        int rear = 0;
        next[rear] = front;
		
		while (rear < next.length - 1) {
			
			if (-1 == front || needle.charAt(front) == needle.charAt(rear)) {
				
				front ++;
				rear ++;
				next[rear] = front;
			}
			else {
				front = next[front];
			}
		}
			
		
        return next; 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String a = "ababac";
		//String a = "aac";
        int[] c = buildNext(a, 6);
        
        String aa = "mississippi";
        String cc = "a";
        
        strStr(aa,cc);
        
        for (int b: c) {
        	System.out.println(b);
        }
        
	}

}
