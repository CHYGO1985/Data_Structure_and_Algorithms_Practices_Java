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
 * num of intervals = num of A - 1
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
        
        int count = 0;
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
        
        // if there is two or moew maxCount in the array, then need to reduce one
        int rest = - 1;
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
            //  AAABBB
            if (rest > 0) fixSum += rest;
        }
        
        return fixSum;
    }
}
