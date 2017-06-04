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
 */ 
public class ShortestWordDistance {

	// method 1: flag method
	/*
	public int shortestDistance(String[] words, String word1, String word2) {
        
        int distance = Integer.MAX_VALUE;
        if (null == words || words.length == 0) return -1;
        if (1 == words.length) return distance;
        
        boolean isPreWord1 = false;
        int prePos = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1) == true ) {
                if (prePos == Integer.MAX_VALUE) {
                    prePos = i;   
                    isPreWord1 = true;
                    continue;
                }
                
                if (isPreWord1 == true) prePos = i;
                // else: cur is word1, pre is word2
                else  {
                    distance = Math.min(i - prePos, distance);
                    prePos = i;
                    isPreWord1 = true;
                }
            }
            
            if (words[i].equals(word2) == true ) {
                if (prePos == Integer.MAX_VALUE) {
                    prePos = i;   
                    continue;
                }
                if (isPreWord1 == true) {
                    distance = Math.min(i - prePos, distance);
                    prePos = i;
                    isPreWord1 = false;
                }
                // else: cur is word1, pre is word2
                else prePos = i;
            }
        }
        return distance;
    }
    */
	
	// method 1.1: refactoring of method 1: 10m, 2ms, beat 81%
	/*
	public int shortestDistance(String[] words, String word1, String word2) {
        
        int distance = Integer.MAX_VALUE;
        if (null == words || words.length == 0) return -1;
        if (1 == words.length) return distance;
        
        boolean isPreWord1 = false;
        int prePos = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1) == true) {
                 
                if (prePos == Integer.MAX_VALUE) {
                    isPreWord1 = true;
                }
                // cur is word1, pre is word2
                if (isPreWord1 == false)  {
                    distance = Math.min(i - prePos, distance);
                    isPreWord1 = true;
                }
                prePos = i;
            }
            
            if (words[i].equals(word2) == true ) {
                
                // if (prePos == Integer.MAX_VALUE) ;
                if (isPreWord1 == true) {
                    distance = Math.min(i - prePos, distance);
                    isPreWord1 = false;
                }
                prePos = i;
            }
        }
        return distance;
    }	
    */
	
	// method 2:use words[prePos].equals(words[i]) == false, to check how current one is compare to previous one
	public int shortestDistance(String[] words, String word1, String word2) {
        
        int distance = Integer.MAX_VALUE;
        if (null == words || words.length == 0) return -1;
        
       int index = -1, minDistance = Integer.MAX_VALUE;
       for (int i = 0; i < words.length; i++) {
          if (words[i].equals(word1) || words[i].equals(word2)) {
             if (index != -1 && words[index].equals(words[i]) == false) {
                minDistance = Math.min(minDistance, i - index);
              }
              index = i;
          }
       }
       return minDistance;
    }
}
