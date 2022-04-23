/**
 * 
 * 1200. Minimum Absolute Difference
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
import java.util.List;
import java.util.LinkedList;

public class MinAbsoluteDiff {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    
    assert arr != null && arr.length >= 2;

      Arrays.sort(arr);

      int minDis = Integer.MAX_VALUE;
      List<List<Integer>> resList = new LinkedList<>();

      for (int idx = 1; idx < arr.length; idx ++) {

        int curDis = arr[idx] - arr[idx - 1];

        if (curDis > minDis) continue;

        if (curDis < minDis) {
            resList.clear();
            minDis = curDis;
        }

        // for curDis <= minDis. do same ops
        resList.add(Arrays.asList(arr[idx - 1], arr[idx]));
      }

      return resList;
  }
}
