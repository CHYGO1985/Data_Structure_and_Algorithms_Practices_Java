import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
	
	// idea: use LinkedHashMap
    // ref: https://discuss.leetcode.com/topic/17433/probably-the-best-java-solution-extend-linkedhashmap/2
    // *** unsolved : do not know about LinkedHashMap
    // *** further quesion: what if I need to implement the remove the eldest ele myself?
    // use a linkedlist to store the visiting status (the lasted visited put to the head, and eldest put on the tail)
    // things learned: 1) linkedhashmap, hashmap, treemap internal implementation 
    // 2) load factor entry > capacity * load factor, then rehash
    
    Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        
        map = new LinkedCappedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        return true == map.containsKey(key) ? map.get(key) : -1;
    }
    
    public void put(int key, int value) {
        map.put(key, value);
    }
    
    // *** how to extend linkedhashmap
    private class LinkedCappedHashMap<K, V> extends LinkedHashMap<K, V> {
        
        int limit;
        
        public LinkedCappedHashMap(int limit) {
            super(16, 0.75f, true);
            this.limit = limit;
        }
        
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > limit;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
