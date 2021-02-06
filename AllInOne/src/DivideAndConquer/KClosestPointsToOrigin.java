import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * 973. K Closest Points to Origin
 * 
 * @author jingjiejiang
 * @history Feb 6, 2021
 * 
 * ref: https://leetcode.com/problems/k-closest-points-to-origin/solution/
 * 
 */
class Solution {
    
    int[][] points;

    public int[][] kClosest(int[][] points, int K) {
        
        this.points = points;
        sort(0, points.length - 1, K);

        return Arrays.copyOfRange(points, 0, K);
    }

    private void sort(int start, int end, int K) {

        // ramdomly choose a pivot
        if (start >= end) return ;
        int randPos = ThreadLocalRandom.current().nextInt(start, end);
        swap(start, randPos);

        int mid = partition(start, end);
        int leftLength = mid - start + 1;
        if (K < leftLength) {
            sort(start, mid - 1, K);
        } else if (K > leftLength) {
            sort(mid + 1, end, K - leftLength);
        }
        // if K == leftLength, then return as normal
    }

    private int partition(int start, int end) {

        int pivotIdx = start;
        int pivotVal = dist(start);
        start ++;

        while (true) {
            // it does not matter if it is < or <=
            while (start < end && dist(start) <= pivotVal) start ++;
            // *** here must be start <= end, as we need K elements, so right + 1 = K, e.g, 0 1 2 3, until 2, we have 3 eles, if we got 3, then we have 4 eles
            while (start <= end && dist(end) >= pivotVal) end --;

            // means all sorted
            if (start >= end) break;
            swap(start, end);
        }

        swap(pivotIdx, end);
        return end;
    }

    private int dist(int idx) {

        return points[idx][0] * points[idx][0] + points[idx][1] * points[idx][1];
    }

    private void swap(int left, int right) {

        int t0 = points[left][0], t1 = points[left][1];
        points[left][0] = points[right][0];
        points[left][1] = points[right][1];
        points[right][0] = t0;
        points[right][1] = t1;
    }
}