package src.TwoPointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 1023. Camelcase Matching
 * 
 * @author jingjiejiang
 * @history Apr 24, 2022
 * 
 */
public class CamelcaseMatching {
  public List<Boolean> camelMatch(String[] queries, String pattern) {
    
    assert queries != null && queries.length >= 1 && pattern != null && pattern.length() >= 1;

    List<Boolean> resList = new ArrayList<>(queries.length);

    for (String query : queries) {
      resList.add(resList.size(), isMatch(query, pattern));
    }

    return resList;
  }

  private boolean isMatch1(String query, String pattern) {

    assert query != null;

    int pQuery = 0, pPattern = 0;

    while (pQuery < query.length() && pPattern < pattern.length()) {

      char patternChar = pattern.charAt(pPattern);
      while (pQuery < query.length()) {
        char queryChar = query.charAt(pQuery);
        if (queryChar == patternChar) break;
        if (Character.isUpperCase(queryChar)){
          return false;
        }
        pQuery ++;
      }

      // pQuery < q.length, means there is a match
      if (pQuery < query.length()) {
        pPattern ++;
        pQuery ++;
      } 

      // pQuery >= q.length, means there is no match, do nothing
    }

    while (pQuery < query.length()) {
      if (Character.isUpperCase(query.charAt(pQuery ++))) return false; 
    }

    return pPattern >= pattern.length() ? true : false;
  }

  private boolean isMatch(String query, String pattern) {

    assert query != null;

    int pPattern = 0;

    for (char charQuery: query.toCharArray()) {
      if (pPattern < pattern.length() && charQuery == pattern.charAt(pPattern)) {
        pPattern ++;
      } else if (Character.isUpperCase(charQuery)) { 
        return false;
      }
    }

    return pPattern >= pattern.length() ? true : false;
  }
}
