import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * round 1: 
 * method 1: solved, 50m, 166ms, beat 56%, hashmap<string, list> + merge two sorted list(check which one is smaller)
 * 
 * Test: 0 match, 1 match
 * 
 * @author jingjiejiang
 * @history Jun 4, 2017
 */
public class ShortestWordDistanceII {

	private Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<>();
        for (int i = 0; i < words.length; i ++) {
            List<Integer> list = map.getOrDefault(words[i], new LinkedList<>());
            list.add(i);
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {

        //if (null == word1 || 0 == word1.length() || null == word2 || 0 == word2.length()) return -1;
        
        int distance = Integer.MAX_VALUE;
        
        // copy the list to avoid changing it
        List<Integer> list1 = new LinkedList<>(map.get(word1));
        List<Integer> list2 = new LinkedList<>(map.get(word2));
        
        if (list1.isEmpty() == true || list2.isEmpty() == true) return distance; 
        
        int index1 = 0, index2 = 0;
        
        while (index1 < list1.size() && index2 < list2.size()) {
            
            int pos1 = list1.get(index1);
            int pos2 = list2.get(index2);
            distance = Math.min(distance, Math.abs(pos1 - pos2));
            // this significantly improve the performance
            if (distance == 1) break;
            
            if (pos1 < pos2) index1 ++;
            // list 2 ele > list 1 ele, then list 2 move to next ele
            else index2 ++;
        }
        
        // do not need to iterate the rest of the list_1 or 2 when one is iterated through
        return distance;
    }
}
