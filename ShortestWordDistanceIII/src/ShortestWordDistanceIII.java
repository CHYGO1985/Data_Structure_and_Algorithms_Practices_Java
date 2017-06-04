/**
 * round 1: 10m, 2ms, beat 74%
 * 
 * @author jingjiejiang
 * @history Jun 4, 2017
 */ 
public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
        
        if (null == words || words.length == 0) return -1;
        boolean isSame = (word1.equals(word2) == true) ? true : false;
        
        int index = -1, minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && ( words[index].equals(words[i]) == false || isSame == true)) {
                    minDistance = Math.min(minDistance, i - index);
                }
                index = i;
            }
        }
       return minDistance;
    }
}
