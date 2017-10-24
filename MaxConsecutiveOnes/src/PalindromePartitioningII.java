
public class PalindromePartitioningII {
	
	public static int minCut(String s) {
        
        if (null == s || 0 == s.length())
            return 0;
        
        int[] lens = manacher(s);
        int count = 0;
        int[] dp = new int[lens.length];
        int right = 0;
        
        for (int i = 2; i < dp.length - 1; i ++) {
        	
            if (lens[i] != 0) {
                dp[i] = dp[i - (lens[i] + 1)] + 1;
                int j = 0;
                while ( ++ j <= lens[i]) {
                    dp[i + j] = dp[i];
                    if (lens[i + j] > lens[i]) {
                    	i = i + j - 1;
                    	break;
                    }
                }
                
                i += j - 1;
            }
            
        }
        
        return dp[dp.length - 2] - 1;
    }
    
    private static char[] preprocess(String str) {
		
		char[] newStr = new char[2 * str.length() + 3];
		
		newStr[0] = '@';
		int index = 1;
		for (; index < newStr.length - 1; index ++)
			newStr[index] = (index % 2 == 0) ? str.charAt(index / 2 - 1) : '#';
			
		newStr[index] = '$';
		
		return newStr;
	}
	
	public static int[] manacher(String str) {
		
		char[] arr = preprocess(str);
				
		int[] lens = new int[arr.length];
		
		int center = 0;
		int right = 0;
		// mirror is needed
		int mirOfRight = 0;
		
		// **** i start from 1, otherwise while will get -1 index detect i - (1 + lens[i]) = -1
		// *** i < arr.length - 1, if < length then, the last mirror will detect i + (1 + lens[i]) = 9
		for (int i = 1; i < arr.length - 1; i ++) {
		
			mirOfRight = 2 * center - i;
			
			if (i < right)
				lens[i] = Math.min(lens[mirOfRight], right - i);
			
			while (arr[i + (1 + lens[i])] == arr[i - (1 + lens[i])]) {
				lens[i] ++;
			}
			
			if (i + lens[i] > right) {
				
				center = i;
				right = i + lens[i];
			}
		}
		
		return lens;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String testString = "abbab";
		int res = minCut(testString);
		System.out.println(res);
	}

}
