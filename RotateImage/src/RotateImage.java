
public class RotateImage {
	
	public  static void rotate(int[][] matrix) {
		// Idea: Drow n=2,3,4 paper to find regulation
        // 1) square cirle
        // a. i + (0 -> (n - 2)), j + ((n-1) -> 1)
        // b. i + ((n -1) -> 1), j - (0 -> (n-2))
        // c. i - (0 -> (n -2)), j - ((n-1) -> 1)
        // d. i - ((n-1) -> 1), j + (0 -> (n-2))
        // 2. number of circles, n/2
        // result: 2ms fastest in the database, beat 61.12
        // things learned: the change of n for every circle
        
        // special case: matrix.length = 0/1
        if (null == matrix || 0 == matrix.length
            || 1 == matrix.length) {
                return;
        }
        
        // loop for numner of circles
        // loop for numner of circles
        int n = matrix.length;
        int circle = n / 2;
        for (int i = 0; i < circle; i ++) {
            
            // init start point of each circle
            int row = i;
            int col = i;
            
            // start from a. step to swap element
            int shift1 = 0;
            int shift2 = n - 1;
            int count = 0;
            // while ( (shift1 <= n - 2) && (shift2 >= 1) ) {
            while ( count <= n - 2 ) {
                
            	int curCol = col + count; 
                int temp = matrix[row][curCol];
                
                // for d, i - ((n-1) -> 1) ==> swap row + ((n-1) -> 1)
                // j + (0 -> (n-2)) ==> swap col - (0 -> (n-2))
                matrix[row][curCol] = matrix[row + shift2][curCol - shift1];
                
                // for c,
                matrix[row + shift2][curCol - shift1] = matrix[row + shift2 + shift1][curCol - shift1 + shift2];
                
                // for b,
                matrix[row + shift2 + shift1][curCol - shift1 + shift2] = matrix[row + shift1][curCol + shift2];
                
                // for a
                matrix[row + shift1][curCol + shift2] = temp;
                count ++;
                shift1 ++;
                shift2 --;
            }
            
            // *** I miss the change of n for every circle for the first time.
            n -= 2;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
		rotate(matrix);

	}

}
