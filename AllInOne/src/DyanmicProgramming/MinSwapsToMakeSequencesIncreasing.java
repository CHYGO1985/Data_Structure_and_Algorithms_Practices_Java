/**
 * 
 * 801. Minimum Swaps To Make Sequences Increasing
 * 
 * @CHYGO1985
 * @history Oct 13, 2020
 * 
 */
class Solution {
    public int minSwap(int[] A, int[] B) {
        
        int fix = 0, swap = 1;

        for (int idx = 1; idx < A.length; idx ++) {

           if (A[idx - 1] >= B[idx] || B[idx - 1] >= A[idx]) {
               swap ++;
           } else if (A[idx - 1] >= A[idx] || B[idx - 1] >= B[idx]) {
               int tmp = swap;
               swap = fix + 1;
               fix = tmp;
           } else {
               int min = Math.min(fix, swap);
               fix = min;
               swap = min + 1;
           }
        }

        return Math.min(fix, swap);
    }
}