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

  public String longestCommonPrefix2(String[] strs) {
		
		assert strs != null && strs.length >= 1;
			
		return longestCommonPrefix(strs, 0 , strs.length - 1);
  }

  private String longestCommonPrefix(String[] strs, int left, int right) {
    
    if (left == right) {
      return strs[left];
    } else {
      int mid = left + (right - left) / 2;
      String lcpLeft = longestCommonPrefix(strs, left, mid);
      String lcpRight = longestCommonPrefix(strs, mid + 1, right);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  private String commonPrefix(String left,String right) {
    
    int min = Math.min(left.length(), right.length());
    for (int idx = 0; idx < min; idx ++) {
      if (left.charAt(idx) != right.charAt(idx)) {
        return left.substring(0, idx);
      }
    }

    return left.substring(0, min);
  }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
