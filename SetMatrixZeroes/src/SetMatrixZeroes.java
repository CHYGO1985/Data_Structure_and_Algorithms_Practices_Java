
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        
        if (0 == matrix.length) {
            return ;
        }
        
        
        boolean[] col = new boolean[matrix[0].length];
        for (int j = 0; j < col.length; j ++) {
            col[j] = true;
        }
        
        for (int i = 0; i < matrix.length; i ++) {
            
            for (int j = 0; j < matrix[0].length; j ++) {
                
                if (0 == matrix[i][j]) {
                    if (true == col[j]) {
                        resetMatrix(matrix, i, j);
                        col[j] = false;
                        break;
                    }
                }
            }
        }
    }
    
    public static void resetMatrix(int[][] matrix, int row, int col) {
        
        // set the whole row to 0
        // set the whole column
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
        
        // set the whole row
        for (int j = 0; j < matrix[0].length; j ++) {
            matrix[row][j] = 0;
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] array = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		
		setZeroes(array);
	}
}
