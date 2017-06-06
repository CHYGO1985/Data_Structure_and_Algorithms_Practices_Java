import java.util.HashMap;
import java.util.Map;

/**
 * round 1: hashtable (matching string), 4 hours, unsolved, misunderstood the question at the beginning
 * 
 * question: for rule 2: For all rows that have a black pixel at column C, they should be exactly the same as row R
 * ("exactly the same": the num and pos of Ws and Bs are all the same)
 * 1. check B in rows, then check B in cols (if rowCount[X] != N, then count ++, change B to W (if rowCount[X] ! = N 
 * then the current num won't be in the final set)
 * 2. two fors check arr[row][col] for rowCount[row] == colCount[col] == N
 * // cannot use the space O(1) method in Lonely Pixel I, as N may very big
 * 
 * @author jingjiejiang
 * @history Jun 5 ,2017
 */
public class LonelyPixelII {
	
	public int findBlackPixel(char[][] picture, int N) {
        
        int count = 0;
        if (null == picture) return count;
        
        int rowLen = picture.length, colLen = picture[0].length;
        int[] rowCount = new int[rowLen];
        int[] colCount = new int[colLen];
        
        // integer is the count of the same row, the same row must equal = N, then it has a chance to have the required B
        Map<String, Integer> map = new HashMap<>();
        
        for (int row = 0; row < rowLen; row ++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < colLen; col ++) {
                builder.append(picture[row][col]);
                if (picture[row][col] == 'B') {
                    rowCount[row] ++;
                    colCount[col] ++;
                }
            }
            
            if (rowCount[row] == N) {
                String temp = builder.toString();
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        int result = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == N) {
                for (int j = 0; j < colLen; j ++) {
                    if (key.charAt(j) == 'B' && colCount[j] == N) {
                        result += N;
                    }
                }
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		// int a = findBlackPixel(new char[][]{{'W', 'B', 'W', 'B', 'B', 'W'},{'W', 'B', 'W', 'B', 'B', 'W'},{'W','B','W', 'B', 'B', 'W'}, {'W', 'W', 'B','W','B','W'}}, 3);
	}
}
