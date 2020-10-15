import java.util.Arrays;

/**
 * 
 * 646. Maximum Length of Pair Chain
 * 
 * @CHYGO1985
 * @history Oct 15, 2020
 * 
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        
        // as [first, second], first < second, so sort according to second
        Arrays.sort(pairs, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int curTop = pairs[0][1];
        int cnt = 1;

        for (int idx = 1; idx < pairs.length; idx ++) {
            if (pairs[idx][0] < curTop) {
                curTop = pairs[idx][1];
                cnt ++;
            }
        }

        return cnt;
    }
}