
public class ImplemetStrStr {
	
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
