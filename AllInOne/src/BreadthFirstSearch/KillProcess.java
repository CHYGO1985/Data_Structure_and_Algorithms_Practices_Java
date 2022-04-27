import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 
 * 582. Kill Process
 * 
 * @author jingjiejiang
 * @history Feb 21, 2021
 * 
 */
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        
        assert pid != null && ppid != null;

        Map<Integer, List<Integer>> parChildMap = new HashMap<>();

        for (int idx = 0; idx < ppid.size(); idx ++) {

            int parent = ppid.get(idx);
            if (parent == 0) continue;

            List<Integer> childList = parChildMap.getOrDefault(parent, 
                new LinkedList<Integer>());
            
            childList.add(pid.get(idx));
            parChildMap.put(parent, childList);
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> delList = new LinkedList<>();

        queue.offer(kill);
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            delList.add(curNode);

            if (parChildMap.containsKey(curNode)) {
                for (int node : parChildMap.get(curNode)) {
                    queue.offer(node);
                }
            }
        }

        return delList;
    }
}