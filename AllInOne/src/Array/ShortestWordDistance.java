package Array;
/**
 * round 1: flag method, 50m, 4ms, beat 20%
 * refactoring: 2ms
 * 1. test cases: 1) only one match
 * 2) with repeat words, ["a","b","c","a","a"]
 * "a",  "b" --> 1
 * 
 * method 2: I used boolean to check how current one is compare to previous one, actually act I can just compare the value
 * words[prePos].equals(words[i]) == false
 * ref: https://discuss.leetcode.com/topic/26065/java-only-need-to-keep-one-index/2
 * 
 * @author jingjiejiang
 * @history Jun 4, 2017
 * Jan 29, 2019
 */ 
public class ShortestWordDistance {

	// method 2:use words[prePos].equals(words[i]) == false, to check how current one is compare to previous one
//	public int shortestDistance(String[] words, String word1, String word2) {
//        
//        int distance = Integer.MAX_VALUE;
//        if (null == words || words.length == 0) return -1;
//        
//       int index = -1, minDistance = Integer.MAX_VALUE;
//       for (int i = 0; i < words.length; i++) {
//          if (words[i].equals(word1) || words[i].equals(word2)) {
//             if (index != -1 && words[index].equals(words[i]) == false) {
//                minDistance = Math.min(minDistance, i - index);
//              }
//              index = i;
//          }
//       }
//       return minDistance;
//    }
	
	public int shortestDistance(String[] words, String word1, String word2) {
		
		int minDis = Integer.MAX_VALUE, preIdx = 0;
		String preWord = null;
		
		for (int idx = 0; idx < words.length; idx ++) {
			if (words[idx].equals(word1) || words[idx].equals(word2)) {
				if (preWord != null && words[idx].equals(preWord) == false) {
					minDis = Math.min(minDis, idx - preIdx);
				}					
				preWord = words[idx]; // if words[idx].equals(preWord) == true
				preIdx = idx; 
			}
		}
		
		return minDis;
    }
}
