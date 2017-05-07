
public class DesignPhoneDirectory {

	// round 1: The question itself is confusing, it does not required get phone number in random style, it can just start
    // from 0.
    // idea: 1) match --> hash / set, but requires restore, then use hash --> or use array
    // 20 minutes, 413ms: beat 93.52%
    
    // *** 1.things learned: resvoir sampling and get random node in a list
    // https://leetcode.com/problems/linked-list-random-node/#/description
    
    int[] entries;
    // *** this is to record the last avail index in entries (reduce the run time)
    int availIndex;

    /** Initialize your data structure here
        @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        
        entries = new int[maxNumbers];
        // 0: the phone number is available; 1: allocated;
        for (int i = 0; i < entries.length; i ++) {
            entries[i] = 0;
        }
        
        availIndex = 0;
    }
    
    /** Provide a number which is not assigned to anyone.
        @return - Return an available number. Return -1 if none is available. */
    public int get() {
        
        /*
        // random method
        int[] picked = new int[2];
        picked[0] = -1;
        picked[1] = -1;
        for (int i = 0; i < list.size(); i ++) {
            int[] curEntry = list.get(i);
            if (curEntry[1] == 1) {
                continue;
            }
            else {
                int rate = (int)(Math.random() * (i + 1));
            
                if (rate == 0)
                    picked = list.get(i);
            }
        }
        
        // *** I forgot to set as allocated
        picked[1] = 1;
        
        return picked[0] == -1 ? -1 : picked[0];
        */
        
        for (int i = availIndex; i < entries.length; i ++) {
            if (entries[i] == 0) {
                entries[i] = 1;
                availIndex = i + 1;
                return i;
            }
        }
        
        return -1;
    }
    
    /** Check if a number is available or not. */
    public boolean check(int number) {
        
        return entries[number] == 0 ? true : false;
    }
    
    /** Recycle or release a number. */
    public void release(int number) {
        
        entries[number] = 0;
        availIndex = Math.min(availIndex, number);
    }
}
