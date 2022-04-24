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



    return res;
  }

  private boolean isMatch(String query, String pattern) {

    assert query != null;

    int pQuery = 0, pPattern = 0;

    while (pQuery < query.length() && pPattern < pattern.length()) {

      char patternChar = pattern.charAt(pPattern);
      while (pQuery < query.length() && query.charAt(pQuery) != patternChar) {
        pQuery ++;
      }

      // pQuery < q.length, means there is a match
      if (pQuery < query.length()) {
        pPattern ++;
        pQuery ++;
      } 

      // pQuery >= q.length, means there is no match, do nothing
    }

    return pPattern >= pattern.length() ? true : false;
  }
}
