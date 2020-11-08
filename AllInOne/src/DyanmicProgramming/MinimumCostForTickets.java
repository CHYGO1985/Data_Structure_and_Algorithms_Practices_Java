import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 983. Minimum Cost For Tickets
 * 
 * @CHYGO1985
 * @history Nov 8, 2020
 * 
 * ref: https://leetcode.com/problems/minimum-cost-for-tickets/discuss/226659/Two-DP-solutions-with-pictures
 * I do not know how to store the interval information: use queue
 * 
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
    
        // int[2] : 0: day, 1: cost (min cost + 7 days/ 30 days pass cost)
        Queue<int[]> last7Days = new LinkedList<>(), last30Days = new LinkedList<>();

        int res = 0;

        for (int day : days) {

            while (!last7Days.isEmpty() && last7Days.peek()[0] + 7 <= day) last7Days.poll();

            // previous day cost + cur day buy 7 days pass
            last7Days.offer(new int[]{day, res + costs[1]});

            while (!last30Days.isEmpty() && last30Days.peek()[0] + 30 <= day) last30Days.poll();

            last30Days.offer(new int[]{day, res + costs[2]});

            // the current day only buy 1 day pass: 1 + res + cost[0] or the cur day is in 7 days or 30 days pass
            res = Math.min(res + costs[0], Math.min(last7Days.peek()[1], last30Days.peek()[1]));
        }

        return res;
    }
}
