import java.util.LinkedList;
import java.util.List;


public class PacificAtlanticWaterFlow {
	
	 // four directions
    private static int[][] coordinate = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    
    
    public static List<int[]> pacificAtlantic(int[][] matrix) {
        // Idea: four directions, typical DFS/BFS question
        // use only one two dimensional array to store result 0x01: PAC ; 0x10: Atl
        // 1) when (row == 0 || col == 0) cell value: |= 0x01; 
        // (row == row - 1 || col = col - 1) cell value: |= 0x10;
        // dfs: quit condition: row < 0 || row >= row || col < 0 || col >= col
        // optimise code: put previous heigth as parameter in DFS, avoid writing four statements
        // ref: https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean/2
        
        // method 2: dfs start from those known area (row == 0 || col == 0) and (row == row - 1 || col = col - 1) 
        // big problem divides into two
        // to find reachable area (used seperate status board for pac and atl)
        // ref: https://discuss.leetcode.com/topic/62379/java-bfs-dfs-from-ocean/2
        // *** acutally use two boolean[][] array is beter than one byte[][] array,
        
        // *** first debug: not data in the res list (cann't assign OxA directly to char, even use (char)0x01 still won't work
        // to save space from using int, should use byte
        
        //*** should do this after checking whether matrix is empty 
        // char[][] status = new char[matrix.length][matrix[0].length];
        
        // *** things learned: 
        // 1) char is not compatible with 0x, should use byte
        // 2) be carefull about &= and |=
        // 3) hexadecimal is different from bit manipulation, for example, when checking == 
        // should not use the condition == 1,  should use 0x10
        // 4) byte: 8 bits, boolean: 1 bit
        
        // I did not consider the direct can to left then to the pac
        List<int[]> res = new LinkedList<int[]>();
        
        // edge case
        if (matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        byte[][] status = new byte[rowLen][colLen];
        
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                dfs(matrix, status, matrix[row][col], row, col);
                if (status[row][col] == 0x11)
                    res.add(new int[]{row, col}); 
            }
        }
        
        return res;
    }
    
    /*
    private static byte dfs (int[][] matrix, byte[][] status, int height, int row, int col) {
        
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] > height)
                return 0x0;
                
        // for the cell that has assign value before, otherwise, temp will be 0x0 for all other cells
        if (status[row][col] != 0x0)
            return status[row][col];
        
        if (row == 0 || col == 0) 
            status[row][col] |= 0x01;
            
        if (row == matrix.length - 1 || col == matrix[0].length - 1)
            status[row][col] |= 0x10;
        
        for (int[] cord: coordinate) {
            // get together all the results from four directions
            status[row][col] |= dfs(matrix, status, matrix[row][col], row + cord[0], col + cord[1]);
        }
        
        return status[row][col];
    }  
    */
    
    private static byte dfs (int[][] matrix, byte[][] status, int height, int row, int col) {
        
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length
                || matrix[row][col] > height)
                return 0x0;
                
        // for the cell that has assign value before, otherwise, temp will be 0x0 for all other cells
        if (status[row][col] != 0x0)
            return status[row][col];
        
        if (row == 0 || col == 0) 
            status[row][col] |= 0x01;
            
        if (row == matrix.length - 1 || col == matrix[0].length - 1)
            status[row][col] |= 0x10;
        
        for (int[] cord: coordinate) {
            // get together all the results from four directions
            status[row][col] |= dfs(matrix, status, matrix[row][col], row + cord[0], col + cord[1]);
        }
        
        return status[row][col];
    } 
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] matrix = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        //int[][] matrix = {{1,2,3},{8,9,4},{7,6,5}};
        List<int[]> list = pacificAtlantic(matrix);
	}

}
