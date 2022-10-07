package src.DyanmicProgramming;

import java.util.Arrays;

/**
 * 
 * 10. Regular Expression Matching
 * 
 * @author jingjiejiang
 * @history Apr 26, 2022
 * 
 * ref: https://leetcode.com/problems/regular-expression-matching/discuss/5651/Easy-DP-Java-Solution-with-detailed-Explanation
 * 
 */
public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {

    assert s!= null && p != null && s.length() >= 1 && p.length() >= 1;

    boolean[][] matchRecords = new boolean[p.length() + 1][s.length() + 1];
    Arrays.fill(matchRecords[0], false);
    matchRecords[0][0] = true;

    for (int row = 1; row < matchRecords.length; row ++) {
      matchRecords[row][0] = p.charAt(row - 1) == '*' && matchRecords[row - 2][0] ? true : false;
    }

    for (int row = 1; row <= p.length(); row ++) {

      char pChar = p.charAt(row - 1);
      for (int col = 1; col <= s.length(); col ++) {

        char sChar = s.charAt(col - 1);
        if (pChar == '.' || pChar == sChar) {
          matchRecords[row][col] = matchRecords[row - 1][col - 1];
        } else if (pChar == '*') {
          if (p.charAt(row - 2) != sChar && p.charAt(row - 2) != '.') {
            matchRecords[row][col] = matchRecords[row - 2][col]; // "X*" count as empty
          } else {
            matchRecords[row][col] = matchRecords[row - 2][col] // if it is '.*', we can go to [row-2][col], it counts as empty
                                      || matchRecords[row - 1][col] // like 'a*'
                                      || matchRecords[row][col - 1]; // if s = 'aa', 'a*', we can check the 1st 'a' in s
          }
        } else {
          matchRecords[row][col] = false;
        }
      }
    }

    return matchRecords[p.length()][s.length()];
  }
}
