/**
 * 
 * 1099. Two Sum Less Than K
 * 
 * @CHYGO1985
 * @history Nov 11, 2020
 * 
 * ref: https://leetcode.com/problems/two-sum-less-than-k/discuss/322931/Java-Sort-then-push-from-two-ends.
 * 
 */
class Solution {
    public int twoSumLessThanK(int[] A, int K) {
        
        Arrays.sort(A);
        
        int maxSum = -1;
        int start = 0, end = A.length - 1;
        
        while (start < end) {

            int sum = A[start] + A[end];
            if (sum < K) {
                maxSum = Math.max(maxSum, sum);
                start ++;
            } else {
                end --;    
            }
        }

        return maxSum;
    }
}