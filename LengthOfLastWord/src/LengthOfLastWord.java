
public class LengthOfLastWord {
	
    public static int lengthOfLastWord(String s) {
        // * idea: 1. straight forward solution: iterate from start to end, skip spaces.
        // special case: 
        // 1) one or more spaces at the front
        // 2) one or more spaces in the middle
        // 3) one or more spaces at the front
        
        /*
        // *** result: 7ms. beat 18.25%, fastest score is 0ms.
        int lenWord = 0;
        
        if (null == s || 0 == s.length()) {
            return lenWord;
        }
        
        int lenStr = s.length();
        int index = 0;
        boolean hasWord = false;
        
        while (index < lenStr) {
                        
            // two cases when meet a space: there is not any word before, there is a word before
            // there is not any word before
                
            // set a sign there is a word
            // if currently there is  not a word in counting
            /*
            while (index < lenStr && s.charAt(index) - ' ' == 0) {
                
                index ++;
            }
            
            if (index == lenStr)
                return lenWord;
                
            if (true == hasWord) {
                
                lenWord = 0;
                hasWord = !hasWord;
            }
           
            while (index < lenStr && s.charAt(index) - ' ' != 0 ) {
               
                lenWord ++;
                index ++;
            }
            
            if (index == lenStr)
                return lenWord;
                
            hasWord = !hasWord;
            
            // *** optimise 1: too many if and while, save some
            // result: 9ms
            if (false == hasWord && s.charAt(index) - ' ' != 0 ) {
                lenWord ++; 
            }
            else if (lenWord != 0 && s.charAt(index) - ' ' == 0 ) {
                hasWord = true;
            }
            else if (true == hasWord && s.charAt(index) - ' ' != 0 ){
                lenWord = 1;
                hasWord = false;
            }
            
            index ++;
            
            // *** optimise 2:
            // result: 9ms
            if (s.charAt(index) - ' ' != 0) {
                if (index > 0 && s.charAt(index - 1) - ' ' == 0) {
                    lenWord = 0;
                }
                lenWord ++;
            }
           
            index ++;
        }
        
        return lenWord;
        */
        
        // two of the leetcode discussion said the following solution is 0 ms. https://discuss.leetcode.com/topic/41927/java-0ms-solution
        // ****** it provides another way of solving the problem, get rid of all the spaces in the string first, the get the last ' ' in the string, return from the end to the pos of the last string.
        // start from behind, reverse thinking.
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex; 
    }

	public static void main(String[] args) {
		
		String a = "Hello World";
		char space = ' ';
		int b = space - ' ';
		
        System.out.println(lengthOfLastWord(a));
        System.out.print(b);
	}

}
