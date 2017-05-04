import java.util.Arrays;


public class Heaters {

	public int findRadius(int[] houses, int[] heaters) {
        // round 1: unsolved, did not think about fit house to heaters one by one when use binary search
        // idea: DP like solution
        // 1) brutal force: use heaters to check all the houses --> O(m(length of houses)*n(length of heaters))
        // 2) improve --> binary search find the place where a <= heater <= c --> O(nlogm)
        
        // method 1: binary search. find the each house in the heater for distance
        // ref: https://discuss.leetcode.com/topic/71460/short-and-clean-java-binary-search-solution/2
        // run time: 30ms
        // *** the behaviour of Arrays.bianrySearch() {2,4}, search 3, return -3
        /*
        Arrays.sort(heaters);
        
        int max = 0;
        
        for (int house : houses) {
        
            int pos = Arrays.binarySearch(heaters, house);
            if (pos < 0)
                pos = - (pos + 1);
            
            int left = pos - 1 >= 0 ? house - heaters[pos - 1] : Integer.MAX_VALUE;
            int right = pos < heaters.length ? heaters[pos] - house : Integer.MAX_VALUE;
            
            max = Math.max(max, Math.min(left, right));
        }
        
        return max;
        */
        // method 2: two pointers tech. Search each heater and the next one, so that can decided the max from house to house
        // refs: https://discuss.leetcode.com/topic/71450/simple-java-solution-with-2-pointers/2
        // run time: 20ms
        Arrays.sort(heaters);
        Arrays.sort(houses);
        
        int max = 0, i = 0;
        for (int house : houses) {
            // *** condition heaters[i] + heaters[i]+1 <= house*2 is very hard to find
            while (i < heaters.length - 1 && heaters[i] + heaters[i + 1] <= house * 2) {
                i ++;
            }
            max = Math.max(max, Math.abs(heaters[i] - house));
        }
        
        return max;
    }

}
