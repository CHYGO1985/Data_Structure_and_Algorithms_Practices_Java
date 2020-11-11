/**
 * 
 * 832. Flipping an Image
 * 
 * @CHYGO1985
 * @history Nov 11, 2020
 * 
 * ref: https://leetcode.com/problems/flipping-an-image/discuss/130590/C%2B%2BJavaPython-Reverse-and-Toggle
 * 
 */
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        
        int len = A.length;
        
        for (int[] row : A) {
            for (int idx = 0; idx * 2 < len; idx ++) {
                if (row[idx] == row[len - 1 - idx]) {
                    row[idx] = row[len - idx - 1] ^= 1;
                }
            }
        }
        
        return A;
    }
}