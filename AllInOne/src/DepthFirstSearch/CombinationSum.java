import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 39. Combination Sum    
 * 
 * @author jingijejiang
 * @history Oct 3, 2020
 * 
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        if (candidates == null || candidates.length == 0) return new LinkedList<>();

        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), candidates, target, 0);

        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tmpList, int[] candidates, int target, int start) {

        if (target < 0) return ;
        else if (target == 0) list.add(new ArrayList<>(tmpList));
        else {
            for (int idx = start; idx < candidates.length; idx ++) {
                tmpList.add(candidates[idx]);
                backtrack(list, tmpList, candidates, target - candidates[idx], idx);
                tmpList.remove(tmpList.size() - 1);
            }
        }
    }
}