/**
 * 
 * 
 * round 1: 
 * TLE for
 * ["a"]
 * 20000
 * 20000
 * 
 * improved method: checking repeat mode : still TLE
 * ["a","bcd"]
 * 20000
 * 20000
 * 
 * @author jingjiejiang
 * @history 
 * 1.Aug 24, 2017
 * 
 */
public class SentenceScreenFitting {

	/*
	public int wordsTyping(String[] sentence, int rows, int cols) {
        //idea: fit the words into two dimensional array one by one
        
        if (null == sentence || 0 == sentence.length) return 0;
        
        // iterate through the whole matrix, check whether words can be inserted into
        int wordIndex = 0;
        int count = 0;
        
        for (int row = 0; row < rows; row ++) {
                   
            int colCapacity = cols;
            while (colCapacity >= 0) {
                String word = sentence[wordIndex];
//                if (colCapacity < word.length) 
//                    colCapacity = -1;
//                else {
//                    wordIndex = (wordIndex + 1) % sentence.length;
//                    colCapacity -= word.length;
//                }
                
                // refactoring
                if (colCapacity >= word.length()) {
                    wordIndex = (wordIndex + 1) % sentence.length;
                    if (wordIndex == 0) count ++;
                }
                colCapacity -= (word.length() + 1);
            }
        }
        
        return count;
    }
    */
	
	/*
	 public int wordsTyping(String[] sentence, int rows, int cols) {
        //idea: fit the words into two dimensional array one by one
        
        if (null == sentence || 0 == sentence.length) return 0;
        
        // iterate through the whole matrix, check whether words can be inserted into
        int wordIndex = 0;
        int count = 0;
        
        int[] dp = new int[cols + 1];
        Arrays.fill(dp, -1);
        
        for (int row = 1; row <= rows; row ++) {
                   
            int colCapacity = 0;
            while (colCapacity <= cols) {
                String word = sentence[wordIndex];
                
                // refactoring
                if ( (cols - colCapacity) >= word.length()) {
                    // *** row / (row - 1) > 1 for case like ["He","sits","dog"] 5 8 (3 rows fit 2 sentence)
                    if (dp[word.length() + colCapacity] == wordIndex && (row / (row - 1) > 1) ) {
                        return rows / (row - 1) * count;
                    }
                    dp[word.length() + colCapacity] = wordIndex;
                    wordIndex = (wordIndex + 1) % sentence.length;
                    if (wordIndex == 0) count ++;
                }
                colCapacity += (word.length() + 1);
            }
        }
        
        return count;
    }
	*/
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		// p[index] means if the row start at index then the start of next row is dp[index].
        int[] dp = new int[sentence.length];
        int n = sentence.length;
        for(int i = 0, prev = 0, len = 0; i < sentence.length; ++i) {
            // remove the length of previous word and space
            if(i != 0 && len > 0) 
            	len -= sentence[i - 1].length() + 1;
            // calculate the start of next line.
            // it's OK the index is beyond the length of array so that 
            // we can use it to count how many words one row has.
            while(len + sentence[prev % n].length() <= cols) 
            	len += sentence[prev++ % n].length() + 1;
            dp[i] = prev;
        }
        int count = 0;
        for(int i = 0, k = 0; i < rows; ++i) {
            // count how many words one row has and move to start of next row.
            // It's better to check if d[k] == k but I find there is no test case on it. 
            // if(dp[k] == k) return 0;
            count += dp[k] - k;
            k = dp[k] % n;
        }
        // divide by the number of words in sentence
        return count / n;
    }
	
	public static void main (String[] args) {
		
		int a = wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6);
	}
}
