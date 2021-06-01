import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 
 * 380. Insert Delete GetRandom O(1)
 * 
 * @author jingjiejiang
 * @history Jun 1, 2021
 * 
 */
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
        
        map = new HashMap<>();
        list = new ArrayList<>();
        
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
           
            int temp = list.get(list.size() - 1);
            list.set(index, temp);
            map.put(temp, index);
            
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

    class RandomizedSet {

        private Map<Integer, Integer> numsMap;
        private List<Integer> numsList;

        /** Initialize your data structure here. */
        public RandomizedSet() {

            numsMap = new HashMap<>();
            numsList = new LinkedList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            
            if (numsMap.containsKey(val)) {
                
                return false;
            } 
                
            numsList.add(val);
            numsMap.put(val, numsList.size() - 1);

            return true;
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {

            if (!numsMap.containsKey(val)) {
                return false;
            }
                
            int tmpIdx = numsMap.get(val);
            int lastNum = numsList.get(numsList.size() - 1);

            numsList.set(tmpIdx, lastNum);
            numsMap.put(lastNum, tmpIdx);

            numsList.remove(numsList.size() - 1);
            numsMap.remove(val);

            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {

            return numsList.get( (int)(Math.random() * numsList.size()) );
        }   
    }
}
