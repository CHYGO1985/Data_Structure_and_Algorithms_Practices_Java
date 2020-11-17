/**
 * 
 * 845. Longest Mountain in Array
 * 
 * @CHYGO1985
 * @author jingjiejiang
 * 
 */
class Solution {
    public int longestMountain(int[] A) {
        
        if (A == null || A.length < 2) return 0;
        
        int res = 0, up = 0, down = 0;
        
        for (int idx = 1; idx < A.length; idx ++) {
            
            if ( (down > 0 && A[idx - 1] < A[idx]) || A[idx - 1] == A[idx]) up = down = 0;
            if (A[idx - 1] < A[idx]) up ++;
            if (A[idx - 1] > A[idx]) down ++;
            if (up > 0 && down > 0 && up + down + 1 > res) res = up + down + 1;
        }
        
        return res;
    }
}