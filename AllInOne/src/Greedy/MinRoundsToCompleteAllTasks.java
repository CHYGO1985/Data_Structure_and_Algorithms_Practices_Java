package src.Greedy;

import java.util.HashMap;

/**
 * 2244. Minimum Rounds to Complete All Tasks
 * 
 */
public class MinRoundsToCompleteAllTasks {
  public int minimumRounds(int[] tasks) {
        
        assert tasks != null && tasks.length > 0;

        int minRounds = 0;

        // task : count
        HashMap<Integer, Integer> taskCntMap = new HashMap<>();

        for (int task : tasks) {
            taskCntMap.put(task, taskCntMap.getOrDefault(task, 0) + 1);
        }

        for (Integer task : taskCntMap.keySet()) {
            int taskCnt = taskCntMap.get(task);

            if (taskCnt < 2) {
                return -1;
            } else {
                minRounds += taskCnt / 3 + (taskCnt % 3 == 0 ? 0 : 1);
            }
        }

        return minRounds;
    }
}
