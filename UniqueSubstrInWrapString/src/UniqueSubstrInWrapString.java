/**
 * 
 * round 1: 
 * 
 * idea: dp + hashmap
 * 
 * @author jingjiejiang
 *
 */
public class UniqueSubstrInWrapString {

public int findSubstringInWraproundString(String p) {
        
        if (null == p || 0 == p.length()) return 0;
        
        Map<String, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        int sum = 0;
        
        // iterate through p to find the increasing strings
        int start = 0;
        int end = 0;
        for (int i = 0; i < p.length() - 1; i ++) {
        
            char temp = p.charAt(i);
            if (set.add(temp) == true) sum ++;
            
            if (p.charAt(i + 1) - temp == 1) 
                end ++;
            else {
            // iterate through the strings to cal the dif substrings
            // use haspmap to prevent counting repeating string
            // "start-end-len : count"
        
                int sum +=
                    
                start = end = i;
            }
        }
        
    }
    
    private int countString(int start, int end, Map<String, Integer> map, String p) {
        
        int shift = start + 1;
        int preLen = 1;
        int count = preLen;
        char frontChar = p.charAt(start);
        
        while (shift <= end) {
            
            char rearChar = p.charAt(shift);
            String key = frontChar + "-" + rearChar + "-" + length;
            if (map.containsKey(key) == false) {
                
                int reverseShift = shift - 1;
                if ()
                map.put(key, preLen); 
                count += preLen;
            }
            else {
                count += map.get
            }
            preLen ++;
            shift ++;
        }
        
        // reduce the repeat part "abcabc" -> eliminate abc, bc
        shift = end - 1;
        char endChar = p.charAt(end);
        while (shift >= start) {
            frontChar = p.charAt(shift);
            String key == front
        }
        
        return count;
    } 
}
