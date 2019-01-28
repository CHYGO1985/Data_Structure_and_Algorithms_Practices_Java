package Array;

/**
 * 
 * @author jingjiejiang Jan 28, 2019
 *
 */
public class sortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		int start = 0, end = A.length - 1;
        boolean conIsTrue = (start % 2 == 0 && A[start] % 2 == 0)
    			|| (start % 2 != 0 && A[start] % 2 != 0);
        while (start < end) {
        	
        	while (start < A.length && conIsTrue) start ++;
        	while (end >= 0 && conIsTrue) end --;
        	
        	if (start < end) {
        		int tmp = A[start];
        		A[start ++] = A[end];
        		A[end --] = tmp;
        	}
        }
        
        return A;
    }
}
