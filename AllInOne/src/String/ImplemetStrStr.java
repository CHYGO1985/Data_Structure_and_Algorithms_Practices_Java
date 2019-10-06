package String;

/**
 * 
 * @author jingjiejiang Feb 23, 2019
 *
 */
public class ImplemetStrStr {
	
// **** thins learned: write pseudo code, which will decrease the time spend on a problem.
    
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
    
    // *** 2nd round: implementation of KMP
	/*
	public static int strStr(String haystack, String needle) {

		// special case: 
		int stackLen = haystack.length();
        int ndlLen = needle.length();
        
        if ( stackLen < ndlLen)
            return -1;
            
        if (true == haystack.isEmpty() || true == needle.isEmpty())
            return 0;
        
        int indexHS = 0;
        int indexND = 0; // do not need to init with -1, as in next array, arr[0] = -1
        int[] next = buildNext(needle, ndlLen);
        
        while(indexHS < haystack.length()) {
        	
        	if ( -1 == indexND || haystack.charAt(indexHS) == needle.charAt(indexND)) {
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
	 */
	
	public int strStr(String haystack, String needle) {
		
		if (needle == null || needle.length() == 0) return 0;
		
		char[] needleArr = needle.toCharArray();
		int[] next = buildNext(needleArr);
		
		int hayIdx = 0, needleIdx = 0;;
		while (hayIdx < haystack.length()) {
			
        	if ( -1 == needleIdx || haystack.charAt(hayIdx) == needleArr[needleIdx]) {
        		hayIdx ++;
        		hayIdx ++;
        		
        	}
        	else {
        		needleIdx = next[needleIdx];
        	}
        	
        	if (needleIdx == needleArr.length) {
        	    return hayIdx - needleArr.length;
        	}
		}
		
        return -1;
    }
	
	private int[] buildNext(char[] needle) {
		
		int[] next = new int[needle.length];
		int front = -1, end = 0;
		next[end] = front;
		
		while (end < next.length) {
			if (front == -1 || needle[front] == needle[end]) {
				
				next[++ end ] = ++ front; 
			} else {
				front = next[front];
			}
		}
		
		return next;
	}
	
	public static void main(String[] args) {
		
//		String a = "ababac";
//		String bb = "bac";
//        int[] c = buildNext(a, 6);
//        
//        String aa = "mississippi";
//        String cc = "a";
//        
//        strStr(aa,cc);
//        
//        for (int b: c) {
//        	System.out.println(b);
//        }
//        
//        System.out.println(strStr(a, bb));
	}
}
