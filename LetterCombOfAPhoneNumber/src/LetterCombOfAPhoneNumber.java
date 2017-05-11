import java.util.LinkedList;
import java.util.List;


public class LetterCombOfAPhoneNumber {
	// round 2: same idea, but try recursive method
	
	// round 1: 40 minutes, 4ms
    // *** stuck at deleting and adding ele to the list at the same time
    // rule: when digit string contains "1" or "0", no matter where it is, output is ""
    // permutation: 
	
	// method 2: same idea, recursive implementation, less code
	// ref: https://discuss.leetcode.com/topic/6380/my-recursive-solution-using-java/2
	private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
	public static List<String> letterCombinations(String digits) {
		List<String> ret = new LinkedList<String>();
		combination("", digits, 0, ret);
		return ret;
	}

    // *** recursive: a (aa,ab,ac). b (ba,bb,bc) ...
	private static void combination(String prefix, String digits, int offset, List<String> ret) {
		if (offset >= digits.length()) {
			ret.add(prefix);
			return;
		}
		String letters = KEYS[(digits.charAt(offset) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			combination(prefix + letters.charAt(i), digits, offset + 1, ret);
		}
	}
	

	/*
	 public List<String> letterCombinations(String digits) {
        // round 1: 40 minutes, 4ms
        // *** stuck at deleting and adding ele to the list at the same time
        // rule: when digit string contains "1" or "0", no matter where it is, output is ""
        // permutation: 
        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "edf";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        
        List<String> list = new LinkedList<String>();
        // assume there is any invalid inputs
        for (int i = 0; i < digits.length(); i ++) {
            int num = digits.charAt(i) - '0';
            if (num == 0 || num == 1) { 
                list.clear();
                return list;
            }
            
            addDigit(list, map[num]);
        }
        
        return list;
    }
	    
    private void addDigit(List<String> list, String alphas) {
        
        String temp = "";
        // *** empty list
        if (list.size() == 0) {
            for (int i = 0; i < alphas.length(); i ++)
                list.add(temp + alphas.charAt(i));
            return ;
        }
        
        int length = list.size(); 
        // *** be very carefull when deleting and adding ele to a list at the same time
        for (int i = 0; i < length; i ++) {
            temp = list.remove(0);
            for (int j = 0; j < alphas.length(); j ++) {
                list.add(temp + alphas.charAt(j));
            }
        }
        
        // refactoring of previous code
        String temp = "";
        int length = list.size();
        do {
            if (length > 0) 
                temp = list.remove(0);
            for (int j = 0; j < alphas.length(); j ++) {
                list.add(temp + alphas.charAt(j));
            }
            length --;
        }
        while (length > 0);
    }
    */
	    
	public static void main(String[] args) {
		List<String> list = letterCombinations("212");
	}
}
