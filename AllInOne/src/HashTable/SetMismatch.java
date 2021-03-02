/**
 * 
 * 645. Set Mismatch
 * 
 * @author jingjiejiang
 * @history Mar 2, 2021
 * 
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        
        assert nums != null && nums.length >= 2;
                
        Map < Integer, Integer > map = new HashMap();
        int dup = -1, missing = 1;
        
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (map.containsKey(i)) {
                if (map.get(i) == 2)
                    dup = i;
            } else
                missing = i;
        }
        return new int[]{dup, missing};
    }
}