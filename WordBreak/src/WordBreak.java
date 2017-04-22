import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordBreak {
    // round 1: *** spend 2 hours work on wrong understanding of the question 
    // test case --> i misunderstood the question: segmented into a space-separated sequence 
    // of one or more dictionary words. -- > I thought match at least one will be true, it required the exact match,
    // the segmented array must contains only words from dict
    /*
    "aaaaaaa"
    ["aaaa", "aa"]
    should return false;
    "leetcode"
    ["leet","cod"]
    should return false;
    "leetcode"
    ["leet","code", "aa"]
    should return true
    */
    
    // idea: trie + hashmap (store the index of beginning letter in the word)
    // *** things learned: nested and inner class
    // refs: https://discuss.leetcode.com/topic/6156/java-implementation-using-dp-in-two-ways
    
    
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        Set<String> set = new HashSet<String>();
        for (String temp : wordDict)
            set.add(temp);
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && set.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}
