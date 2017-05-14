
public class NumberOfSegments {

	public int countSegments(String s) {
		// Round 1: 25ms, multiple errors, the bahaviour of split(" ") for corner cases
        // *** Java String learned the behaviouf pf split(" ")
        // 1) multi continuous spaces
        // 2) leading spaces
        // 3) a string str.length() == 0, 
        // 1. test case: *** "    "
        
        if (null == s || 0 == s.length()) return 0;
        s = s.replaceAll(" +", " ");
        s = s.trim();
        // *** for test case: "     "
        if (s.length() == 0) return 0;
        String[] strs = s.split(" ");
        return strs.length;
    }
}
