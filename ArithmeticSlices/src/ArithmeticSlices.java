
public class ArithmeticSlices {
	
	public int numberOfArithmeticSlices(int[] A) {
        // * idea: 1. find the longest slice, 2. the regulation will be: n -> 1, n-1 -> 2, n-2 -> 3, ..., until n=3, then
        // sume of (1, 2, 3, ..., (num of n=3))
        // *** I was wrong about the quesion, it ask the slices in the array, so for[1,2,3,5,7,9,11,15], (1,2,3) also count
        // 1 for the final result
        // 1. Find the longest slice
        // *** result: 2 ms, beat 35.64%, fastest is 2ms.
        
        int result = 0;
        
        if (A.length < 3) {
            return result;
        }
        
        int max = 0;
        int dif = A[1] - A[0];
        int slice = 1;
    
        for (int i = 1; i < A.length - 1; i ++) {
            if ( dif == (A[i + 1] - A[i]) ) {
                result += slice;
                slice += 1;
            }
            else {
                dif = A[i + 1] - A[i];
                slice = 1;
            }
        }
        
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
