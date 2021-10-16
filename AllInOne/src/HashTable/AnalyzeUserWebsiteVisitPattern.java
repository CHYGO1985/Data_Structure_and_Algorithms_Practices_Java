import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 
 * 1152. Analyze User Website Visit Pattern
 * 
 * @author jingjiejiang
 * @history Oct 8, 2021
 * Oct 6, 2021
 * 
 * same idea as this one: https://leetcode.com/problems/analyze-user-website-visit-pattern/discuss/550403/Java-Solution%3A-With-Comments-95-faster
 * 
 */
public class AnalyzeUserWebsiteVisitPattern {

  static class Visit {

    String userName;
    int timestamp;
    String website;

    Visit (String userName, int timestamp, String website) {
      this.userName = userName;
      this.timestamp = timestamp;
      this.website = website;
    }

    Visit() { }
  }

  public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        
    // Convert all the entry as visit objects
    List<Visit> visitList = new ArrayList<>();

    for (int idx = 0; idx < username.length; idx ++) {
      visitList.add(new Visit(username[idx], timestamp[idx], website[idx]));
    }

    // Sort all the visit entries based on tiemstamp
    Comparator<Visit> cmp = (v1, v2) -> v1.timestamp - v2.timestamp;
    Collections.sort(visitList, cmp);

    // Collect list of websits for each user
    Map<String, List<String>> userWebsiteMap = new HashMap<>();
    for (Visit visit : visitList) {
      userWebsiteMap.putIfAbsent(visit.userName, new ArrayList<>());
      userWebsiteMap.get(visit.userName).add(visit.website);

      // check 
      // userWebsiteMap.getOrDefault(visit.userName, new ArrayList<>()).add(visit.website);
    }

    Map<List<String>, Integer> seqUserFreqMap = new HashMap<>();

    // Get all values of all the users
    for (List<String> websiteList : userWebsiteMap.values()) {
      if (websiteList.size() < 3) continue;

      Set<List<String>> seqSet = generate3Seq(websiteList);

      // update the frequency of the sequence
      for (List<String> seq : seqSet) {

        seqUserFreqMap.put(seq, seqUserFreqMap.getOrDefault(seq, 0) + 1);
      }
    }

    List<String> res = new ArrayList<>();
    int max = 0;

    for (Map.Entry<List<String>, Integer> entry : seqUserFreqMap.entrySet()) {

      if (entry.getValue() > max) {
        max = entry.getValue();
        res = entry.getKey();
      } else if (entry.getValue() == max) {
        if (entry.getKey().toString().compareTo(res.toString()) < 0) {
          res = entry.getKey();
        }
      }
    }

    return res;
  }

  private Set<List<String>> generate3Seq(List<String> websiteList) {

    Set<List<String>> setOfListSeq = new HashSet<>();

    for (int fst = 0; fst < websiteList.size(); fst ++) {
      for (int sec = fst + 1; sec < websiteList.size(); sec ++) {
        for (int third = sec + 1; third < websiteList.size(); third ++) {

          List<String> list = new ArrayList<>();
          list.add(websiteList.get(fst));
          list.add(websiteList.get(sec));
          list.add(websiteList.get(third));
          setOfListSeq.add(list);
        }
      }
    }

    return setOfListSeq;
  }
}
