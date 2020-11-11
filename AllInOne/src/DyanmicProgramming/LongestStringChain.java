import java.util.Arrays;
import java.util.Map;

/**
 * 
 * 1048. Longest String Chain
 * 
 * @CHYGO1985
 * @history Nov 11, 2020
 * 
 * ref: https://leetcode.com/problems/longest-string-chain/discuss/294890/C%2B%2BJavaPython-DP-Solution
 * 
 */
class Solution {
    public int longestStrChain(String[] words) {
        
        if (words == null || words.length == 0) return 0;

        int res = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        // Map<String, Integer> word and its longest chain length
        Map<String, Integer> wordChainLen = new HashMap<>();

        for (String word : words) {

            int curLongest = 0;
            // skip letters in word one by one, and then check if there exist previous word
            for (int idx = 0; idx < word.length(); idx ++) {

                String prev = word.substring(0, idx) + word.substring(idx + 1);
                curLongest = Math.max(curLongest, wordChainLen.getOrDefault(prev, 0) + 1);
            }

            wordChainLen.put(word, curLongest);
            res = Math.max(res, curLongest);
        }

        return res;
    }
}
