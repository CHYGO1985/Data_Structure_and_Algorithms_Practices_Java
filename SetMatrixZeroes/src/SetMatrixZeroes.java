
public class SetMatrixZeroes {

	// Idea: method 1: use the O(mn) extra space to store the status
    // method 2: used O(m + n) extra space to store the status, after that, change the according to the
    // status to change the matrix
    // method 3: use constant space to store multiple information --> bit manipulation
    // *** bit manipulation only works for limited number of arrays
    // method 4: use only 
    // ref: https://discuss.leetcode.com/topic/62769/java-2-solutions-space-o-1-and-o-m-n-with-explaination
    
    public void setZeroes(int[][] matrix) {
        
        if(matrix==null) return;
        final int M=matrix.length, N=matrix[0].length;
        boolean topZero=false, leftZero=false;
        
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j]==0){
                    if(i==0) topZero = true;
                    if(j==0) leftZero = true;
                    
                    // set the first ele of this row as 0
                    matrix[i][0] = 0;
                    // set the first ele of the col as 0
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<M; i++){
            if(matrix[i][0]==0){
                for(int q=1; q<N; q++) 
                    matrix[i][q] = 0;
            }
        }
        
        for(int j=1; j<N; j++){
            if(matrix[0][j]==0){
                for(int p=1; p<M; p++)  
                    matrix[p][j] = 0;
            }
        }
        
        if(topZero){
            for(int q=0; q<N; q++) matrix[0][q] = 0;
        }
        if(leftZero){
            for(int p=0; p<M; p++) matrix[p][0] = 0;
        }
        /*
        if (0 == matrix.length) {
            return ;
        }
        
        long rowChecker = Long.MAX_VALUE;
        long colChecker = Long.MAX_VALUE;
        
        for (int i = 0; i < matrix.length; i ++) {
            
            boolean isZeroRow = false;
            for (int j = 0; j < matrix[0].length; j ++) {
                
                if (0 == matrix[i][j]) {
                    isZeroRow = true;
                    
                    if ( ((colChecker ^ Long.MAX_VALUE) & (1 << j)) >> j != 1) {
                        colChecker ^= 1 << j;
                    }
                }
            }
            
            if (true == isZeroRow) {
                rowChecker ^= 1 << i;
            }
        }
        
        // check rows
        for (int row = 0; row < matrix.length; row ++) {
            
            if ( ((rowChecker ^ Long.MAX_VALUE) & (1 << row)) >> row == 1) {
                
                for (int col = 0; col < matrix[0].length; col ++) {
                    matrix[row][col] = 0;
                }
            }
        }
        
        // check columns
        for (int col = 0; col < matrix[0].length; col ++) {
            
            if ( ((colChecker ^ Long.MAX_VALUE) & (1 << col)) >> col == 1) {
                
                for (int row = 0; row < matrix.length; row ++) {
                    matrix[row][col] = 0;
                }
            }
        }
        */
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
