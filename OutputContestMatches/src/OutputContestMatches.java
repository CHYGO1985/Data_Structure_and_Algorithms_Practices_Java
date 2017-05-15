import java.util.LinkedList;
import java.util.List;


public class OutputContestMatches {
	
	public static String findContestMatch(int n) {
        // round 1: unsolved
        // bottom-up
        // 1) first: get all the combination
        // 2) combine two by two
        // ref: https://discuss.leetcode.com/topic/83454/java-10-lines
        
        List<String> eles = new LinkedList<String>();
        for (int i = 1; i <= n; i ++) {
            eles.add(String.valueOf(i));
        }
        
        while (eles.size() != 1) {
            List<String> recons = new LinkedList<String>();
            for (int i = 0; i < eles.size() / 2; i ++)
                recons.add("(" + eles.get(i) + "," + eles.get(eles.size() - i - 1) + ")");
            eles = recons;
        }
        
        return eles.get(0);
    }
}
