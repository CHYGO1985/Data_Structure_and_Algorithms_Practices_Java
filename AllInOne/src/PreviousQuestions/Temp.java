package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 31, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public int leastInterval(char[] tasks, int n) {
        // get the most frenquent task's count
		// if 2max - sum >= 1
		//   return max + n*(max - 1)
		// else
		//   sum += freq == max ? freq - (max - 1)
		//   if (rest taks - n * (max - 1) > 0)
		//   sum += the val 
		if (null == tasks || 0 == tasks.length) return 0;
        
        int[] chars = new int[26];
        int maxCount = 0;
        int sum = tasks.length;
        
        for (char temp : tasks) {
            chars[temp - 'A'] += 1;
            maxCount = Math.max(maxCount, chars[temp - 'A']);
        }
        
        int base = maxCount + n * (maxCount - 1);
//        if (2 * maxCount - sum >= 1) {
//        	return base;
//        }
//        else {
//        	int gapSum = 0;
//        	for (int idx = 0; idx < chars.length; idx ++) {
//        		int gap = chars[idx] - (maxCount - 1);
//        	    gapSum += gap > 0 ? gap : 0;
//        	}
//        	
//        	base += (sum - maxCount > n * (maxCount - 1)) ? 
//            sum - maxCount - n * (maxCount - 1) : gapSum - 1;
//        }
        
        // ** optimise
        if (2 * maxCount - sum < 1) {
        	int gapSum = 0;
        	for (int idx = 0; idx < chars.length; idx ++) {
        		int gap = chars[idx] - (maxCount - 1);
        	    gapSum += gap > 0 ? gap : 0;
        	}
        	
        	base += (sum - maxCount > n * (maxCount - 1)) ? 
            sum - maxCount - n * (maxCount - 1) : gapSum - 1;
        }
        
        return base;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,3};
	}
}
