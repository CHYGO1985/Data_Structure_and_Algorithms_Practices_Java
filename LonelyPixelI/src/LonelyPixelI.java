
/**
 * round 1: solved, 30m (method1), 46ms, beat 20%
 * method 1: similar eliminate 0 in a matrix problem, flag method: flag array for matrix.
 * 
 * 
 * @author jingjiejiang
 * @history Jun 5, 2017
 */ 
public class LonelyPixelI {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
