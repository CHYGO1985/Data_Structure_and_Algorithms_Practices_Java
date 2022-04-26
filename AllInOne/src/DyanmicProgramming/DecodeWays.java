/**
 *
 * 91. Decode Ways
 * 
 * @author jingjiejiang
 * @history Apr 26, 2022
 * 
 */
public class DecodeWays {
  public int numDecodings(String s) {
        
    assert s!= null && s.length() >= 1;

    int[] decodeWays = new int[s.length() + 1];
    decodeWays[0] = 1;

    for (int idx = 1; idx < decodeWays.length; idx ++) {
      
      char curChar = s.charAt(idx - 1);
      decodeWays[idx] = curChar == '0' ? 0 : decodeWays[idx - 1];

      if (idx > 1 && ( s.charAt(idx - 2) == '1' || (s.charAt(idx - 2) == '2' && curChar <= '6'))) {
        decodeWays[idx] += decodeWays[idx - 2];
      }
    }

    return decodeWays[decodeWays.length - 1];
  }
}
