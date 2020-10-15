import javax.lang.model.element.Element;

/**
 * 
 * 517. Super Washing Machines
 * 
 * @CHYGO1985
 * @history Oct 15, 2020
 * 
 * ref: https://leetcode.com/problems/super-washing-machines/discuss/99188/Java-O(n)-DP-Solution
 * 
 */
class Solution {
    public int findMinMoves(int[] machines) {
        
        int sum = 0;

        for (int machine : machines) {
            sum += machine;
        }

        if (sum % machines.length != 0) return -1;
        
        int target = sum / machines.length;
        int times = 0;
        int[] moves = new int[machines.length];

        for (int idx = 0; idx < machines.length - 1; idx ++) {

            if (machines[idx] > target) {
                moves[idx] += machines[idx] - target;
                machines[idx + 1] += machines[idx] - target;
                machines[idx] = target;
                times = Math.max(times, moves[idx]);
            } else {
                moves[idx + 1] = target - machines[idx];
                machines[idx + 1] -= target - machines[idx];
                machines[idx] = target;
                times = Math.max(times, moves[idx + 1]);
            }
        }

        return times;
    }
}