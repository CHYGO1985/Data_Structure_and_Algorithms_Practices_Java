import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class LongestUncomSubseqII {
	
	public static int findLUSlength(String[] strs) {
        // round 2: 
        
        // round 1: used 2 hours to understand the questions, another 3 hours to solve it 
        // Used 1 hours to understand the questions (the meaning of subsequences)
        // idea: the hardest part is to get different subseq of a string
        // ["ab","ab", "ab", "a"] = -1 (a is the subsequence of ab)
        // ["ab","ab","c"] = 1
        // test case:
        // *** ["abc","abc", "ab", "c"] = -1
        // *** ["abc", "abc", "ac"] = -1
        // *** ["aaa","aaa","aa"] = -1 (this is not suitable for array set)
        // *** ["aabbcc", "aabbcc","bc","bcc"]
        
        // *** Java String: indexOf() find match string
        
        // sort from longest to shortest
        Map<String, Integer> subseqFreq = new HashMap<>();
	    for (String s : strs) 
	        for (String subSeq : getSubseqs(s))
	            subseqFreq.put(subSeq, subseqFreq.getOrDefault(subSeq, 0) + 1);
	    int longest = -1;
	    for (Map.Entry<String, Integer> entry : subseqFreq.entrySet()) 
	        if (entry.getValue() == 1) longest = Math.max(longest, entry.getKey().length());
	    return longest;
    }
    
    // *** recursive design.
    public static Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        for (String seq : subRes) res.add(s.charAt(0) + seq);
        return res;
    }

	public static void main(String[] args) {
		
		findLUSlength(new String[]{"abc", "ab"});
	}

}
