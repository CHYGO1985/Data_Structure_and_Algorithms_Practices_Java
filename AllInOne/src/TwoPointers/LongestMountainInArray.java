package TwoPointers;
/**
 * 
 * 845. Longest Mountain in Array
 * 
 * @CHYGO1985
 * @author jingjiejiang
 * 
 * @history May 24, 2021
 * 
 */
class Solution {
    public int longestMountain(int[] A) {
        
        if (A == null || A.length < 2) return 0;
        
        int res = 0, up = 0, down = 0;
        
        for (int idx = 1; idx < A.length; idx ++) {
            
            if ( (down > 0 && A[idx - 1] < A[idx]) || A[idx - 1] == A[idx]) up = down = 0;
            
            if (A[idx - 1] < A[idx]) up ++;
            else if (A[idx - 1] > A[idx]) down ++;
            
            // cannot use Math.max here, for array like [2,2,2]
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        
        return res;
    }
}