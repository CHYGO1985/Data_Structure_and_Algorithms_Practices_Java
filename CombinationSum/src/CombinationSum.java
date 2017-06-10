import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * round 1: 1 hour, solved, dfs (backtracking),  
 * *** implementation of backtracking
 * 1. always copy the non-primitive type in backtracking
 * 2. the order of quit condition 
 * 
 * @author jingjiejiang
 * @history Jun 10, 2017
 */ 
public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> list = new LinkedList<>();
        if (null == candidates || 0 == candidates.length) return list;
        Arrays.sort(candidates);
        dfs(list, new LinkedList<Integer>(), candidates, target, 0);
        
        return list;
    }
    
    public void dfs(List<List<Integer>> list, List<Integer> curList, int[] candidates, int target, int begin) {
        
        // *** order put wrong, lead to 0 output
        if (target == 0) {
            list.add(curList);
            return;
        }
        if (target < candidates[begin]) return;
        
        for (int i = begin; i < candidates.length; i++) {
            curList.add(candidates[i]);
            // *** always copy the non-primitive type in backtracking
            dfs(list, new LinkedList<>(curList), candidates, target - candidates[i], i);
            curList.remove(curList.size() - 1);
        }
    }
}
