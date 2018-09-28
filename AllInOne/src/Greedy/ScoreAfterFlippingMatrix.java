package Greedy;

/**
 * solved
 * @author jingjiejiang created on Aug 28, 2018
 *
 */
public class ScoreAfterFlippingMatrix {
	
	// to get MAX:
	// 1) all the first digit must be one
	// 2) for the col >= 1, if 1 < row count/2, change flip the col
	// 3) get the the sum of each row
	public static int matrixScore(int[][] A) {
		
		if (A == null || A.length == 0 || A[0].length == 0) {
			return 0;
		}
		
        int rowCount = A.length, colCount = A[0].length;
        
        for (int row = 0; row < rowCount; row ++) {
        	if (A[row][0] == 0) {
        		flipRow(A[row]);
        	}
        }
        
        // I can actually get the sum here, without the last double for loop
        for (int col = 1; col < colCount; col ++) {
        	int oneCount = 0;
        	for (int row = 0; row < rowCount; row ++) {
        		if (A[row][col] == 1) {
        			oneCount ++;
        		}
        	}
        	if (oneCount > A.length/2 == false) {
    			flipCol(A, col);
    		}
        }
        
        int sum = 0;
        // 0 1 2
        // 4 2 1
        for (int row = 0; row < rowCount; row ++) {
        	int temp = 0;
        	for (int col = 0; col < colCount; col ++) {
        		temp += A[row][col] * Math.pow(2, colCount - 1 - col);
        	}
        	sum += temp;
        }
        
        return sum;
    }
	
	public static void flipRow(int[] nums) {
		
		for (int row = 0; row < nums.length; row ++) {
			nums[row] ^= 1; 
		}
	}
	
	public static void flipCol(int[][] A, int colNum) {
		
		for (int row = 0; row < A.length; row ++) {
			A[row][colNum] ^= 1;
		}
	}
	

	public static void main(String[] args) {
		int[][] nums = new int[][]{{0,0,1,1}, {1,0,1,0}, {1,1,0,0}};
		System.out.println(matrixScore(nums));
	}

}
