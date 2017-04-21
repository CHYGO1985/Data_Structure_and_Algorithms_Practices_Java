import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InsertDeleteGetRandom {

	// round 1: 40 minutes, beat 90.25% 
    // *** learn to keep original index in a list when remove an ele (swap with the last one)
    // *** 1) learn how to get iterator in set
    // *** do not use index - 1 here, as index won't exceed list.size()
    
    // idea: resvoir sampling for random
    // O(1) complexity for random --> linkedlist can use i to identify a val
    
    private Map<Integer, Integer> map;
    private List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if (map.containsKey(val) == true) {
            return false;
        }
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        
        if (map.containsKey(val) == true) {
            int index = map.get(val);
            // *** avoid index change: swap the replaced one with the last one, renew the map
            // ref: https://discuss.leetcode.com/topic/53216/java-solution-using-a-hashmap-and-an-arraylist-
            // along-with-a-follow-up-131-ms
            if (index < list.size() - 1) {
                int temp = list.get(list.size() - 1);
                list.set(index, temp);
                map.put(temp, index);
            }
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        else {
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        
        int index = (int)(Math.random() * list.size());
        // *** do not use index - 1 here, as index won't exceed list.size()
        return list.get(index);
    }
}
