import java.util.Arrays;
import java.util.List;


public class ValidWordSquare {
	
public boolean validWordSquare(List<String> words) {
        
        // round 1: 50 minutes, one test case did not consider
        // runtime: 23ms,  beat 79.18%
        // idea: 
        // 1) use set --> but test case " abc" "abc " will generate error output
        // 2) use StringBuilder
        
        // test cass: 1. ***["abc","b"], when row1 reaches the end, c haven't checked yet
        // *** ArrayList initial with capacity: ArrayList(int initialCapacity)
        
        // method 2: how to check wrong condition, see
        // ref https://discuss.leetcode.com/topic/63387/java-ac-solution-easy-to-understand/2
        
        if (words.size() == 0)
            return true;
            
        for (int row = 0; row < words.size(); row ++) {
            String rowStr = words.get(row);
            int row1 = 0;
            for (; row1 < words.size(); row1 ++) {
                String colStr = words.get(row1);
                // *** notice that for rowStr, the index is shifting according to row1
                if ( (row1 < rowStr.length() && row < colStr.length() 
                    && rowStr.charAt(row1) == colStr.charAt(row))
                    || (row1 >= rowStr.length() && row >= colStr.length()) ) {
                    continue;
                }
                
                return false;
            }
            
            // *** for test case: ["abc","b"]
            if (row1 < rowStr.length())
                return false;
        }
        
        return true;
    }

	public static void main(String[] args) {
       String[] arr = {"abc","b"};
       List<String> list = Arrays.asList(arr);
	}

}
