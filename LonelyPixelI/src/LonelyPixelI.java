
/**
 * round 1: solved, 30m (method1), 46ms, beat 20%
 * method 1: O(m*n), spaceO(m+n), similar eliminate 0 in a matrix problem, flag method: flag array for matrix.
 * 
 * method 2: flag method in two dimensional array
 * use the first row and first col to record the appreance of certain data in the corresponding array. 
 * for [0][0] : coz it cannot represent row[0] and col[0] at the same time.  use a seperate variable to record 
 * row[0] and [0][0] for col[0]
 * ref:  https://discuss.leetcode.com/topic/81680/java-o-nm-time-with-o-n-m-space-and-o-1-space-solutions 
 *
 * @author jingjiejiang
 * @history Jun 5, 2017
 */ 
public class LonelyPixelI {
	
	// method 1:
	/*
	public int findLonelyPixel(char[][] picture) {
        
        int count = 0;
        if (null == picture) return count;
        
        int rowLen = picture.length;
        int colLen = picture[0].length;
        if (rowLen == 0 || colLen == 0) return count;
        
        int[] rowCount = new int[rowLen];
        int[] colCount = new int[colLen];
        
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                if (picture[row][col] == 'B') {
                    rowCount[row] ++;
                    colCount[col] ++;
                }
            }
        }
        
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                if (picture[row][col] == 'B' && rowCount[row] == 1 && colCount[col] == 1) count ++;
            }
        }
        
        return count;
    }
    */
	
	// method 2: flag method in two dimensional array
	// use the first row and first col to record the appreance of certain data in the corresponding array. 
	// for [0][0] : coz it cannot represent row[0] and col[0] at the same time.  use a seperate variable to record row[0] and [0][0] for col[0]
	// ref:  https://discuss.leetcode.com/topic/81680/java-o-nm-time-with-o-n-m-space-and-o-1-space-solutions
	public static int findLonelyPixel(char[][] picture) {
		
		int rowLen = picture.length, colLen = picture[0].length;
		// for [0][0] : coz it cannot represent row[0] and col[0] at the same time. use a seperate variable to record row[0] and [0][0] for col[0]
        int fstRowCount = 0;
        
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
                if (picture[row][col] == 'B') {
                	// use < 'Y', the char can still reach to Y, means the col has at least two Bs
                    if (picture[0][col] < 'Y' && picture[0][col] != 'V') picture[0][col] ++;
                    if (row == 0) fstRowCount ++;
                    else if (picture[row][0] < 'Y' && picture[row][0] != 'V') picture[row][0] ++;
                }
            }
        }
        
        int count = 0;
        for (int row = 0; row < rowLen; row ++) {
            for (int col = 0; col < colLen; col ++) {
            	// this conditions to find 'B' or 'C's, iF 'B' is at row[0] or col[0], it is 'C' (if only one 'B')
	        	// 'C' ,must be at row [0] position
                if (picture[row][col] < 'W' && (picture[0][col] == 'C' || picture[0][col] == 'X')) {
                    if (row == 0) count += (fstRowCount == 1) ? 1 : 0;
                    // check rows whether it is only added 1
                    else if (picture[row][0] == 'C' || picture[row][0] == 'X') count ++;
                }
            }
        }
        
        return count;
	}

	public static void main(String[] args) {
		int a = findLonelyPixel(new char[][]{{'W', 'W', 'W', 'B'},{'W', 'B', 'B', 'W'},{'W','B','W','W'}, {'B','W','W','W'}});

	}

}
