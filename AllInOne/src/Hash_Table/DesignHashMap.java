package Hash_Table;

import java.util.LinkedList;
import java.util.List;

public class DesignHashMap {
	
	private List<Integer> dataList;
	
	public DesignHashMap() {
        dataList = new LinkedList<>();
        // init for 10 bucket
        for (int idx = 0; idx <= 1000000; idx ++) {
        	dataList.add(-1);
        }
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	
    	int insertPos = key == dataList.size() - 1 ? key - 1 : key;
    	dataList.remove(key);
    	dataList.add(insertPos, value);
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return dataList.get(key);
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	int insertPos = key == dataList.size() - 1 ? key - 1 : key;
    	dataList.remove(key);
    	dataList.add(insertPos, -1);
    }
}
