import java.util.Arrays;

/**
 * 
 * 
 * round 1: 
 * 1) I first implement brutal force idea, then I got TLE error for test case (["a"], 2000, 2000)
 * 2) the error reminds me that I should optimise the method, so I do not need to compute the repeated case
 * and I observer that for every start of a word in a row, it ends in an identical index for each wordIndex(*** check explain below)
 * , if there is a math in such index, it means that I can use the prvious result to get the final result.
 * 
 * 3) *** the problem of 2) is that for case like ("hello", "world"), cols = 8, they both ends 
 * at index 6, so every time the dp[6] just change from 0 to 1 then 1 to 0, it does not really solve the problem
 * e.g. rows = 2, cols = 8, sentence = ["a"]
 * "hello" ends at 6, and then "world" ends at 6 as well
 * 
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
 * ref: DP solution ref: https://discuss.leetcode.com/topic/62364/java-optimized-solution-17ms/2
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
	
	 public static int wordsTyping(String[] sentence, int rows, int cols) {
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
                	// or "hello", "world"}, 2, 8)
                    if (dp[word.length() + colCapacity] == wordIndex && (row / (row - 1) > 1) ) {
                    	// for repeated case, do not need to iterate through all the rows again, just rep the
                    	// result of previous rows
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
	
	// ref: https://discuss.leetcode.com/topic/62364/java-optimized-solution-17ms/2
	// DP solution, add my own comments
	/*
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		// p[index] means if the row start at index then the start of next row is dp[index].
        int[] dp = new int[sentence.length];
        int n = sentence.length;
        // *** prev has two usage: 1) is used to record how many ele has been used to fill a row since the start of this row
        // 2) prev % n is the index in sentence (used to get the start of next row)
        for(int i = 0, prev = 0, len = 0; i < sentence.length; ++i) {
            // remove the length of previous word and space, means the current len represent the row start with i
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
        	// *** e.g. for rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
        	// a-bcd- 
        	// e-a---
        	// bcd-e-
        	// 1) dp[0] = 2, so count = 2, and next row start with index 2 ("e")
        	// 2) for the next row, it start with index 2 ("e"), we can the num
        	// of ele has been used in this row via counting dp[k] - k, then we
        	// get the next start index via dp[k] % n...
            count += dp[k] - k;
            k = dp[k] % n;
        }
        // divide by the number of words in sentence
        return count / n;
    }
    */
	
	public static void main (String[] args) {
		
		// int a = wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6);
		int a = wordsTyping(new String[]{"hello", "world"}, 2, 8);
	}
}
