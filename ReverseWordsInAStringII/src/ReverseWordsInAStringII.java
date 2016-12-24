
public class ReverseWordsInAStringII {
	
	
	// method 2: reverse the whole string first, then reverse each word (O(n))
    // ref: https://discuss.leetcode.com/topic/8366/my-java-solution-with-explanation
    
    public static void reverseWords(char[] s) {
        // Three step to reverse
        // 1, reverse the whole sentence
        reverse(s, 0, s.length - 1);
        // 2, reverse each word
        int start = 0;
        int end = -1;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }
        // 3, reverse the last word, if there is only one word this will solve the corner case
        reverse(s, start, s.length - 1);
    }

    public static void reverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
	/*
	public static void moveWord(char[] s, int startPos, int wordPos) {
        
        // keep the char for swapping
        int arrLen = s.length;
        
        // shift all the left part (start from startPos) of "wordPos" to right within one unit
        for (int i = wordPos; i < arrLen; i ++) {
            
            char temp = s[i];
            
            int j = i - 1;
            for (; j >= startPos; j --) {
                
                s[j + 1] = s[j];
            }
            
            j ++;
            s[j] = temp;
            startPos ++;
        }
        
        // shift all left part of new word to right within one unit to cover the space at the end
        int m = s.length - 2;
        for (; m >= startPos; m --) {
            
            s[m  + 1] = s[m];
        }
        
        // put a new space after the new word
        m ++;
        s[m] = ' ';
    }
    
    public static void reverseWords(char[] s) {
        // Idea: two pointers technique
        // 1) num of space + 1 = num of word
        // 2) loop as the_sky_is_blue
        // --> blue_ (the_sky_is)
        // --> blue_is_ (the_sky)
        // --> blue_is_sky_the
        // 3) for every single loop
        // a. from rear, find a space where pos is A,
        // b. start from A + 1, shift the word 
        // c. new pos = startPos + (char pos + len of word) % total len 
        // d. at the space at the end to the place next to shifted word
        // e. back to step a
        
        // handle special case
        if (null == s || 0 == s.length) {
            return ;
        }
        
        int searchSpace = s.length;
        // find a space from the rear of s
        int startPoint = 0;
        int wordCount = 0;
        
        // *** need a word count to stop the reversing
        for (int i = searchSpace - 1; i >= 0; i --) {
        	
            if (' ' == s[i]) {
            	wordCount ++;
            }
        }
        
        for (int i = searchSpace - 1; wordCount >0 && i >= 0; i --) {
            
            if (' ' == s[i]) {
                
                // swap the word from i + 1
                moveWord(s, startPoint, i + 1);
                startPoint += searchSpace - i;
                
                // *** when there is a match, reset i
                i = searchSpace - 1;
                wordCount --;
            }
        }
    }
    */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
        char[] s= {'t', 'h', 'e', ' ',
        		  's', 'k', 'y', ' ',
        		  'i', 's', ' ',
        		  'b', 'l', 'u', 'e'};
        */
		
		char[] s = {'s', 'k', 'y'};
        reverseWords(s);
        
        for (char c: s) {
        	
        	System.out.print(c);
        }
	}
}
