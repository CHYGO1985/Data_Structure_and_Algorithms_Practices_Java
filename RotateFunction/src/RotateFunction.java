
public class RotateFunction {
	
	public static int maxRotateFunction(int[] A) {
        // * idea: get the rotated array directly (do need to actually rotate the array, just get the result directly), then count all the sums, return the max one
        // *** result: 1020 - 1063 ms, beat 2%, most of the solution was on 4 -6 ms.
        // consider optimisation:
        // sort the array, then 
        
        // I used initial value for max = 0 which is wrong, as the sum may be neg number, [-1, -1]
		// so I should use it as the most smaller number in integer.
		/*
        int max = Integer.MIN_VALUE;
        
        if (0 == A.length || null == A) {
            return 0;
        }
        
        int length = A.length;
        
        for (int rotate = 0; rotate < length; rotate ++) {
            
            int curSum = 0;
            
            for (int i = 0; i < length; i ++) {
                
                if (i < rotate) {
                    // from 0 to rotate -1 in the new array, 
                    // the ele will be: new[i] = A[i + (A.length - rotate)]
                   curSum = curSum + i * A[i + length - rotate]; 
                }
                // when i >= rotate
                else {
                    // from rotate to length - 1, the ele in the new array will be
                    // new [i] = A[j - rotate];
                    curSum = curSum + i * A[i - rotate];
                }
            }
            
            max = Math.max(curSum, max);
        }
        
        return max;
        */
        
        // *** *** best solution http://www.cnblogs.com/grandyang/p/5869791.html
        // it came from observing the result, then get the law
        // two things：1) Mathematical Induction
        // 2) use simple simble to represent the results, it can make things much easier to observe.
        int n = A.length;
    	int sum = 0;
    	int candidate = 0;
    
    	for (int i = 0; i < n; i++) {
    		sum += A[i];
    		candidate += A[i] * i;
    	}
    	int best = candidate;
    
    	for (int i = 1; i < n; i++) {
    		candidate = candidate - sum + A[i - 1] * n;
    		best = Math.max(best, candidate);
    	}
    	return best;
    }

	public static void main(String[] args) {
      
		int[] a = {-2147483648,-2147483648};
		
		int sum = maxRotateFunction(a);
		
		System.out.println(sum);
	}

}
