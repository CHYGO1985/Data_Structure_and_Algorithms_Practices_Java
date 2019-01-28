package Array;

/**
 * 
 * @author jingjiejiang Jan 28, 2019
 *
 */
public class SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
        // two pointers tech
        int start = 0, end = A.length - 1;
        
        while (start < end) {
        	
        	while (start < A.length && A[start] % 2 == 0) start ++;
        	while (end >= 0 && A[end] % 2 != 0) end --;
        	
        	if (start < end) {
        		int tmp = A[start];
        		A[start ++] = A[end];
        		A[end --] = tmp;
        	}
        }
        
        return A;
    }
}
