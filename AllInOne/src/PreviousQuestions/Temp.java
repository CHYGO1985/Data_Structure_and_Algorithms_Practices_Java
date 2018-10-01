package PreviousQuestions;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Oct 1st, 2018
 *
 */
public class Temp {

	public static int leastInterval(char[] tasks, int n) {
		// get the frequecies of each char in the array and the most appearance char X
		// from the most appearance, construct the res array (do not need to)
		// if back to X and inerval < n, add length till gap = n
		
		if (null == tasks || 0 == tasks.length) return 0;
        
        int[] chars = new int[26];
        int maxCount = 0;
        int sum = tasks.length;
        
        for (char temp : tasks) {
            chars[temp - 'A'] += 1;
            maxCount = Math.max(maxCount, chars[temp - 'A']);
        }
        
        // not repeat
        if (maxCount == 1) return sum;
        int rest = 0;
        // check whether there is num of other > (maxCount - 1) e.g. AAABBB,
        for (int i : chars) {
            if (i - (maxCount - 1) > 0)
                rest += i - (maxCount - 1);
        }
        
        int fixSum = n * (maxCount - 1) + maxCount;
        // nums of rest > avail idles
        if (sum - maxCount > n * (maxCount - 1))
            // fixSum = sum
            fixSum += sum - maxCount - n * (maxCount - 1);
        else {
            // AAABBB
        	
            fixSum += rest -1;
        }
        
        //rest - 1: coz the for loop will count maxCount char, so -1 of the 1 got from max count char
        fixSum += (sum - maxCount > n * (maxCount - 1)) ? 
        		sum - maxCount - n * (maxCount - 1) : rest - 1;
        		
        
        return fixSum;
    }
	
	public static void main(String[] args) {
	}

}
