/**
 * 
 * 304. Range Sum Query 2D - Immutable
 * 
 * @CHYGO1985
 * @history Oct 23, 2020
 * 
 */
class NumMatrix {

    private int[][] matSums;
    
    public NumMatrix(int[][] matrix) {
                
        if (matrix.length == 0 || matrix[0].length == 0) {
            
            matSums = new int[0][0];
            return ;
        }
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        matSums = new int[rowLen + 1][colLen + 1];

        for (int row = 1; row < matSums.length; row ++) {
            for (int col = 1; col < matSums[0].length; col ++) {

                matSums[row][col] = matrix[row - 1][col - 1] + matSums[row][col - 1] + matSums[row - 1][col]
                    - matSums[row - 1][col - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        
        if (matSums.length == 0 || matSums[0].length == 0) return 0;
        
        // must be carefull about the coord transfer from matSums[][] to matrix[][]
        return matSums[row2 + 1][col2 + 1] - matSums[row1][col2 + 1] - matSums[row2 + 1][col1]
             + matSums[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */