package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Oct 20, 2018
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
        
        // get basic interval count of the frame
        int fixSum = n * (maxCount - 1) + maxCount;
        int surpass = 0;
        
        // if cur count > (maxCnt - 1), then frame += cur count - (maxCnt - 1)
        for (int cntOfChar : chars) {
        	int curSurPass = cntOfChar - (maxCount - 1);
        	surpass += curSurPass > 0 ? curSurPass : 0; 
        }
        
        // check num of chars - n * (maxCount - 1) > 0
        // if > 0, then return task.length
        // esle, return fixSum + surpass - 1
        fixSum += (sum - maxCount > n * (maxCount - 1)) ? 
        		sum - maxCount - n * (maxCount - 1) : surpass - 1;
        	
        return fixSum;
    }
	
	public static void main(String[] args) {
	}
}
