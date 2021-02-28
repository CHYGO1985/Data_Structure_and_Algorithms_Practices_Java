import java.awt.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 
 * 1086. High Five
 * 
 * @author jingjiejiang
 * @history Feb 28, 2021
 * 
 */
class Solution {
    public int[][] highFive(int[][] items) {
        
        assert items != null && items.length >= 1;

        Map<Integer, Queue<Integer>> idScoresMap = new TreeMap<>(); 
        int maxLen = 5;

        for (int idx = 0; idx < items.length; idx ++) {

            int id = items[idx][0];
            int score = items[idx][1];

            if (!idScoresMap.containsKey(id)) {
                idScoresMap.put(id, new PriorityQueue<>((a, b) -> b - a));
            }
            
            idScoresMap.get(id).offer(score);
        }

        List<int[]> res = new LinkedList<>();

        for (int id : idScoresMap.keySet()) {

            int sum = 0;
            for (int idx = 0; idx < maxLen; idx ++) {
                sum += idScoresMap.get(id).poll();
            }

            res.add(new int[]{id, sum / maxLen});
        }

        int[][] resArr = new int[res.size()][2];

        return res.toArray(resArr);
    }
}
