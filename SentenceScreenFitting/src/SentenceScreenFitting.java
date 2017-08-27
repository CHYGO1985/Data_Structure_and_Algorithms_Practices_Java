
/**
 * 
 * 418. Sentence Screen Fitting
 * 
 * round 1: unsolved (TLE), do not know how to optimise from brutal force solution. 
 * (did not thing about transform 2 dimensional problem to 1 dimensional problem.)
 * 
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
 * 4) *** the key to optimise from brutal force solution is to change the question to 2-dimensional array to 
 * 1-dimensional array
 * 
 * improved method: checking repeat mode : still TLE
 * ["a","bcd"] 20000 20000
 * 
 * Method 1: DP
 * ref: DP solution ref: https://discuss.leetcode.com/topic/62364/java-optimized-solution-17ms/2
 * The DP solution transfer from a 2 dimensional array to one dimensional array problem
 * e.g. ("a", "bcd", "e"), 3, 6
 * we switch to a one dimensional array question 
 * a _ b c d _ e _ a _ b  c  d  _  e  _  a  _  b  c  d  _  e  _
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
 * 1) A dumb way we can check the next start index for each word is to use brutal force, check one by one,
 * However, it is still use many time for repeated calculation
 *  a _ bcd _ e _ f _ g _ ... _ z
 *  bcd _ e _ f _ ... _ z _ a
 *  e _ f _ ... _ z _ a _ bcd
 *  
 *  We can see that it recalculated many repeated cases
 *  
 * 2) to optimise it, we change it to a 1 dimensional array, so the previous added words.length can still be
 * kept, we only need to exclude the length of the previous starter word.
 * 
 * The process is:
 * 1) start from a (index = 0), we got (a _ b c d _) len = 6, wordsCount = 2, dp[0] = 2
 * 2) start from bcd (index = 1), we use len - (a_).length = 4, then start count, as (b c d _).length already
 * in len, so we start with next word e, which index = wordsCount % sentence.length
 * get (b c d _ e _) len = 6, wordsCount = 3. dp[1] = 3
 * 3) start from e (index = 2), get (e _ a _ _ _) len = 4, wordsCount = 4
 * so dp[2] = 4
 * 
 * Method 2: transform to 1 dimensional array, then use the total length of each array (cols) to check how many
 * sentence it can contains. 
 * ref: https://discuss.leetcode.com/topic/62455/21ms-18-lines-java-solution
 * 
 * e.g. ("a", "bcd", "e"), 3, 6
 * we switch to a one dimensional array question (a _ b c d _ e _ : leng is 8) 
 * we used the suffix _ here, as it is convenient to connect to a 1 dimensional array
 * a _ b c d _ e _ a _ b  c  d  _  e  _  a  _  b  c  d  _  e  _
 * 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23
 * 0 1 2 3 4 5
 *             0 1 2 3 (_ _)
 *                     0  1  2  3  4  5
 *                     
 * We can see the total length is 16 (this is what we need to find). which is 'a' at index 16.
 * From the process, we can find that 
 * 1) if end is at a '_' (the first line), then start with next one
 * 2) if end is at a char (the second line 'c'), then we go back until meets a _
 * 
 * @author jingjiejiang
 * @history 
 * 1.Aug 24, 2017
 * 2.Aug 28, 2017
 * 1) Add analysis of method 2
 */
public class SentenceScreenFitting {

	// Method 1: brutal force
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
	
	
	// DP : used dp array to save the end pos of each words with index i
	/*
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
    */
	
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
	
	// my implementation of DP method
	/*
	public static int wordsTyping(String[] sentence, int rows, int cols) {
        
        if (null == sentence || 0 == sentence.length) return 0;
        
        int[] dp = new int[sentence.length];
        
        int wordsCount = 0;
        int len = 0;
        // get all the "next start index" for each word in the sentence
        for (int i = 0; i < sentence.length; i ++) {
            
            if (len > 0)
                len -= sentence[i - 1].length() + 1;
            
            // iterate through each cols, check whether how many words the a row can contain
            // when start with sentence[i]
            
            // when i start with 0, len should add from i;
            // when i > 1, len should add from i + 1 (as i already in the len)
            // *** so we use wordsCount here for the index
            while (len + sentence[wordsCount % sentence.length].length() <= cols)
                len += sentence[(wordsCount ++) % sentence.length ].length() + 1;
            
            dp[i] = wordsCount;
        }
        
        int count = 0;
        int startIndex = 0;
        // from 0 to row, get all the words count
        for (int i = 0; i < rows; i ++) {
            
            count += dp[startIndex] - startIndex;
            startIndex = dp[startIndex] % sentence.length;
        }
        
        return count / sentence.length;
    }
	*/
	
	public static int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            // *** we do not use start - 1 here, as we are going to find the
            // index at 16 not 15, see explaination at the beginning
            
            // 1) a row must start with a char not ' '
            if (s.charAt(start % l) == ' ') {
                start++;
            // 2) a row cannot be ended in the mid of a word 
            } else {
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }
        
        return start / s.length();
    }
	
	public static void main (String[] args) {
		
		int a = wordsTyping(new String[]{"a", "bcd", "e"}, 3, 6);
		// int a = wordsTyping(new String[]{"hello", "world"}, 2, 8);
		System.out.println(a);
	}
}
