package src.String;

/**
 * 
 * @author jingjiejiang Feb 23, 2019
 * ref: https://leetcode.com/problems/longest-common-prefix/
 *
 */
public class LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		
		if (strs == null || strs.length == 0) return "";
			
		String res = "", pre = strs[0];
		int idx = 1;
		
		while (idx < strs.length) {
      //this loop is to find the first match of the two
			while (strs[idx].indexOf(pre) != 0) {
				pre = pre.substring(0, pre.length() - 1);
			}
            
      idx ++;
		}
		
		return pre;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
