import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
  public static int solution(int[] x, int[] y) {
    // Your code here
    Set<Integer> xNumSet = fillSet(x);
    Set<Integer> yNumSet = fillSet(y);

    Set<Integer> longSet = xNumSet.size() > yNumSet.size() ? xNumSet : yNumSet;
    Set<Integer> shortSet = xNumSet.size() > yNumSet.size() ? yNumSet : xNumSet;

    for (int num : longSet) {
      if (!shortSet.contains(num)) return num;
    }

    return 0;
  }

  private static Set<Integer> fillSet(int[] nums) {
      
      Set<Integer> numSet = new HashSet<>();
      
      for (int num : nums) {
          numSet.add(num);
      }
      
      return numSet;
  }

  public static void main(String[] args) {
      // int a = solution(new int[]{13, 5, 6, 2, 5}, new int[]{5, 2, 5, 13});

      int a = solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50});

      System.out.println(a);
  }
}
