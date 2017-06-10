import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * round 1: 40m, dfs (backtracking), 22ms, beat 75.09%
 * idea: 1 1 2 3 4 : target 6
 * 1 1 4 is allowed
 * 1(0) 2 3
 * 1(1) 2 3 is duplicate
 * to avoid such duplicate, add if (i > begin && candidates[i] == candidates[i - 1]) continue;
 * 
 * @author jingjiejiang
 * @history Jun 10, 2017
 */
public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
        List<List<Integer>> list = new LinkedList<>();
        if (null == candidates || 0 == candidates.length) return list;
        Arrays.sort(candidates);
        dfs(list, new LinkedList<Integer>(), candidates, target, 0);
        
        return list;
    }
    
    private void dfs(List<List<Integer>> list, List<Integer> curList, int[] candidates, int target, int begin) {
        
        if (target == 0) {
            list.add(new ArrayList<Integer>(curList));
            return ;
        }
        // *** also becaful here about begin < candidates.length
        if (begin < candidates.length && target < candidates[begin]) return ;
        
        // do not use length - 1. it will not work when length == 1,
        for (int i = begin; i < candidates.length; i ++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            curList.add(candidates[i]);
            dfs(list, curList, candidates, target - candidates[i], i + 1);
            curList.remove(curList.size() - 1);
        }
    }
}
