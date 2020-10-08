import java.util.Map;

/**
 * 
 * 170. Two Sum III - Data structure design
 * 
 * @CHYGO1985
 * @history Oct 8, 2020
 * 
 */
class TwoSum {
    
    private List<Integer> numsList;
    private Map<Integer, Integer> matchMap;

    /** Initialize your data structure here. */
    public TwoSum() {
        
        numsList = new LinkedList<>();
        matchMap = new HashMap<>();
        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        
        numsList.add(number);
        matchMap.put(number, matchMap.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for (int idx = 0; idx < numsList.size(); idx ++) {
            int num = numsList.get(idx);
            int matchCount = matchMap.getOrDefault(value - num, 0);
            
            if (num == value - num) {
                if (matchCount >= 2) return true;
            } else {
                if (matchCount >= 1) return true;
            }
        }
        
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */