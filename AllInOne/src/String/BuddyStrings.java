import java.util.List;

/**
 * 
 * 859. Buddy Strings
 * 
 * @author jingjiejiang
 * @history Oct 12, 2020
 * 
 * ref: https://leetcode.com/problems/buddy-strings/discuss/141780/Easy-Understood
 * 
 */
class Solution {
  public boolean buddyStrings(String A, String B) {
      
    if (A.length() != B.length()) return false;

    Set<Character> charSet = new HashSet<>();
    List<Integer> idxList = new ArrayList<>();

    if (A.equals(B)) {
      for (int idx = 0; idx < A.length(); idx ++) {
        charSet.add(A.charAt(idx));
      }

      return charSet.size() < A.length() ? true : false;
    }
    
    for (int idx = 0; idx < A.length(); idx ++) {
      if (A.charAt(idx) != B.charAt(idx)) idxList.add(idx);
    }

    return idxList.size() == 2 && A.charAt(idxList.get(0)) == B.charAt(idxList.get(1))
      && A.charAt(idxList.get(1)) == B.charAt(idxList.get(0));
  }
}