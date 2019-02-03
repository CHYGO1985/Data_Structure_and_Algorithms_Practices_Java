package Hash_Table;

import java.util.Arrays;

/**
 * 
 * @author jingjiejiang Feb 3, 2019
 *
 */
public class DesignHashMap {
	
	private int[] dataArr;
	
	public DesignHashMap() {
		dataArr = new int[1000001];
		Arrays.fill(dataArr, -1);
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	
    	dataArr[key] = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return dataArr[key];
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
    	dataArr[key] = -1;
    }
}
