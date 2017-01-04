
import java.util.LinkedList;
import java.util.List;


public class SpiralMatrix {
	
	public static List<Integer> circleMatrix(int[][] matrix, int startRow, int startCol
	        , int rowLimit, int colLimit) {
	        
	        List<Integer> list = new LinkedList<Integer>();
	        int tempRow = startRow;
	        int tempCol = startCol;
	        
	        //*** did not consider the relative limit at the beginning
	        int curRowLimit = rowLimit + startRow;
	        int curColLimit = colLimit + startCol;
	        
	        // from start point to rightmost, col + 1 until col < limit
	        for (; tempCol < curColLimit; tempCol ++) {
	            
	            list.add(matrix[tempRow][tempCol]);
	        }
	        
	        // elimiate the last 1 added in the for loop
	        tempCol--;
	        
	        // from rightmost to down direction, row + 1 until row < limit
	        // the first row have been added
	        tempRow ++;
	        // *** I did not add this condition, so it will coz error when there is only one row
	        if (0 == rowLimit - 1) {
	            return list;
	        }
	        
	        for (; tempRow < curRowLimit; tempRow ++) {
	            
	            list.add(matrix[tempRow][tempCol]);
	        }
	        
	        tempRow --; 
	        
	        // from bottom-right to left dir, col - 1 until col = startCol
	        // the last col has been added col - 1
	        tempCol --;
	        
	        if (0 == colLimit - 1) {
	            return list;
	        }
	        
	        for (; tempCol >= startCol; tempCol --) {
	            
	            list.add(matrix[tempRow][tempCol]);
	        }
	        
	        tempCol ++;
	        
	        // from left dir back to start point, row - 1 until row = startRow
	        // the bottom row has been added, row - 1
	        tempRow --;
	        for (; tempRow > startRow; tempRow --) {
	            
	            list.add(matrix[tempRow][tempCol]);
	        }
	        
	        return list;
	    }
	    
	    public List<Integer> spiralOrder(int[][] matrix) {
	        // idea: DFS related (similar to "Rotate Image")
	        // 1) each loop: right, down, left and up
	        // 2) loop start point: 0,0, 1.1
	        // 3) number of loop: according to the num of min(row, col) (coz every turn, row - 2 and col - 2)
	        // min(row, col)/2 + 1(if num % 2 != 0)
	        // 4) every circle, row limit = row - 1, col limit = col -1
	        // row = row - 2 and col = col -2
	        // *** test case: did not design for only one row 
	        // result: 3ms, 15.36%, 57.37% is 3ms , fastest is 2ms, 27/36%
	        
	        List<Integer> list = new LinkedList<Integer>();
	        
	        // special case: null or matrix.length == 1
	        if (null == matrix || 0 == matrix.length) {
	            return list;
	        }
	        
	        int length = matrix.length;
	        int wide = matrix[0].length;
	        
	        // start from 0,0, loop for min(row + col) /2 + 1 (num%2 != 0)
	        int min = Math.min(length, wide);
	        
	        int count = min / 2;
	        if (min % 2 != 0) {
	            count ++;
	        }
	        
	        int startRow = 0;
	        int startCol = 0;
	        
	        for (int i = 0; i < count; i ++) {
	            
	            List<Integer> temp = circleMatrix(matrix, startRow + i, startCol + i, length, wide);
	            list.addAll(temp);
	            length -= 2;
	            wide -= 2;
	        }
	        
	        return list;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
