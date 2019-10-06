package Array;

/**
 * 
 * @author jingjiejiang Jan 28, 2019
 *
 */
public class sortArrayByParityII {
	public int[] sortArrayByParityII(int[] A) {
		int even = 0, odd = even + 1;

		while (even < A.length && odd < A.length) {
        	
        	while (even < A.length && A[even] % 2 == 0) even += 2;
        	while (odd < A.length && A[odd] % 2 != 0) odd += 2;
        	
        	if (even < A.length && odd < A.length) {
        		int tmp = A[even];
        		A[even] = A[odd];
        		A[odd] = tmp;
        		even += 2;
        		odd += 2;
        	}
        }
        
        return A;
    }
}
