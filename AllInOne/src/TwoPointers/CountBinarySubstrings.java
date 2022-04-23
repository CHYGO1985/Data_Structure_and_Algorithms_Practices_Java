/**
 * 
 * 696. Count Binary Substrings
 * 
 * @author jingjiejiang
 * @history Apr 23, 2022
 * 
 */
public class CountBinarySubstrings {
  public int countBinarySubstrings(String s) {
        
    assert s != null && s.length() >= 1  && s.length() < Math.pow(10, 5);
    
    int sum = 0, preLen = 0, curLen = 1;

    for (int idx = 1; idx < s.length(); idx ++) {

      if (s.charAt(idx - 1) != s.charAt(idx)) {
        sum += Math.min(preLen, curLen);
        preLen = curLen;
        curLen = 1;
      } else {
        curLen ++;
      }
    }

    return sum + Math.min(preLen, curLen);
  }
}
