import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 1074. Number of Submatrices That Sum to Target
 * 
 * @CHYGO1985
 * @history Oct 7, 2020
 * 
 */
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        
        int res = 0, rowLen = matrix.length, colLen = matrix[0].length;
        // complement number of target : count, e.g. 1 - target = complement number
        Map<Integer, Integer> compNumsMap = new HashMap<>();

        // cal presum be rows
        for (int rowIdx = 0; rowIdx < rowLen; rowIdx ++) {
            for (int colIdx = 1; colIdx < colLen; colIdx ++) {
                matrix[rowIdx][colIdx] += matrix[rowIdx][colIdx - 1];        
            }
        }

        // use hashmap and traverse (col + col + row traverse) the matrix to get sub matrix sum that match the target
        // traverse: cal sums by cols and reduce the pre sums if start col > 0
        for (int colIdx1 = 0; colIdx1 < colLen; colIdx1 ++) {
            for (int colIdx2 = colIdx1; colIdx2 < colLen; colIdx2 ++) {

                compNumsMap.clear();
                compNumsMap.put(0, 1);
                int cur = 0;

                for (int rowIdx = 0; rowIdx < rowLen; rowIdx ++) {
                    cur += matrix[rowIdx][colIdx2] - (colIdx1 > 0? matrix[rowIdx][colIdx1 - 1] : 0);
                    res += compNumsMap.getOrDefault(cur - target, 0);
                    compNumsMap.put(cur, compNumsMap.getOrDefault(cur, 0) + 1);
                }
            }
        }
        
        return res;
    }
}