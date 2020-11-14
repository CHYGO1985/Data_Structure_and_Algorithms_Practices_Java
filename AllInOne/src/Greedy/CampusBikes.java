import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 1057. Campus Bikes
 * 
 * @CHYGO1985
 * @history Nov 14, 2020
 * 
 * ref: https://leetcode.com/problems/campus-bikes/discuss/305603/Java-Fully-Explained
 * 
 */
class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        // create a customized priority queue: [0, 1, 2]
        // 0: dist || 1: worker idx || 2: bike idx
        Queue<int[]> assignedPairs = new PriorityQueue<>((a, b) -> {

            int compRes = Integer.compare(a[0], b[0]);

            // if multi same dist, then choose min worker idx
            if (compRes == 0) {
                if (a[1] == b[1]) { // if multi ways for one worker, choose min bike idx
                    return Integer.compare(a[2], b[2]);
                } 

                return Integer.compare(a[1], b[1]);
            }

            return compRes;
        }); 

        // iterate all [dist, worker, bike] triple possibilities and add them to the priority queue
        for (int workerIdx = 0; workerIdx < workers.length; workerIdx ++) {
            
            int[] worker = workers[workerIdx];
            for (int bikeIdx = 0; bikeIdx < bikes.length; bikeIdx ++) {

                int[] bike = bikes[bikeIdx];
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                assignedPairs.offer(new int[]{dist, workerIdx, bikeIdx}); 
            }
        }
        
        // pop the triple from pri queue, check if worker idx and bike are used or not, if not add to res array
        // res array res[idx] equals to idx of workers[]
        // use another array to record if a bike has been assigned 
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        
        int[] addedBikes = new int[bikes.length];
        Arrays.fill(addedBikes, -1);
        int assignedBikeCnt = 0;

        // as bikes.length >= workers.length, so should use worker.length as bar
        while (assignedBikeCnt < workers.length) {
            
            int[] curPair = assignedPairs.poll();
            
            // curPair[1] : worker idx : curPair[2] : bike idx
            if (res[curPair[1]] == -1 && addedBikes[curPair[2]] == -1) {

                res[curPair[1]] = curPair[2];
                addedBikes[curPair[2]] = 1;
                assignedBikeCnt ++;
            }
        }

        return res;
    }
}
