import jdk.internal.jline.internal.TestAccessible;

/**
 * 
 * 1198. Find Smallest Common Element in All Rows
 * 
 * @author jingjiejiang
 * @history Mar 22, 2021
 * 
 * ref: https://leetcode.com/problems/find-smallest-common-element-in-all-rows/solution/
 * 
 */
class Solution {
    // count from column is better than row
    public int smallestCommonElement1(int[][] mat) {
        
        assert mat != null && mat.length >= 1;

        int[] counts = new int[10001];
        Arrays.fill(counts, 0);
        int rowLen = mat.length, colLen = mat[0].length;

        for (int col = 0; col < colLen; col ++) {

            for (int row = 0; row < rowLen; row ++) {
                counts[mat[row][col]] += 1;
            }
        }

        for (int num = 1; num < counts.length; num ++) {
            if (counts[num] == rowLen) return num;
        }

        return -1;
    }

    public int smallestCommonElement2(int[][] mat) {
        
        assert mat != null && mat.length >= 1;

        int[] counts = new int[10001];
        Arrays.fill(counts, 0);
        int rowLen = mat.length, colLen = mat[0].length;

        for (int col = 0; col < colLen; col ++) {

            for (int row = 0; row < rowLen; row ++) {
                if (++ counts[mat[row][col]] == rowLen) {
                    return mat[row][col];
                }
            }
        }

        return -1;
    }
}