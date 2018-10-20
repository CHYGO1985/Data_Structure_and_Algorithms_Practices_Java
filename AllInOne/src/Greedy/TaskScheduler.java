package Greedy;
/**
 * 
 * 621. Task Scheduler
 * 
 * round 1: 1.5 hours, solved, 30m to understand the quesiton, Greedy
 * 
 * idea: 1) it can be found that the length is depend on the char appear the
 * most in the array.
 * e.g. 3A, 3B, 2C,2D,2E n = 2	
 * so the basic frame will be A _ _ A _ _ A
 * 
 * num of (not individual but the total intervals between As) intervals = num of A - 1
 * 
 * 2) based on the assumption, we need to decide how many chars are there
 * out of A _ _ A _ _ A
 * 
 * 3) cause the order does not matter, we can tell that if num of other chars
 * > n * (A - 1) (empty places)
 * then total = sum 
 * 
 * 4) if <=. we need to consider the case like AAABBB, nums of B > (A - 1)
 * so, except from, we need one more for B A _ _ A _ _ A B
 * which is frame + (appear num of X - (A - 1))  
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 24, 2017
 */
public class TaskScheduler {

	// round 1: the question is hard to understand, took 30 minutes
    public int leastInterval(char[] tasks, int n) {
        
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
        //rest - 1: coz the for loop will count maxCount char, so -1 of the 1 got from max count char
        fixSum += (sum - maxCount > n * (maxCount - 1)) ? 
        		sum - maxCount - n * (maxCount - 1) : rest - 1;
        
        return fixSum;
    }
}
