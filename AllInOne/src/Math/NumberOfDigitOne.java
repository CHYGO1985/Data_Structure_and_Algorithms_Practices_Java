/**
 * 
 * 233. Number of Digit One
 * 
 * @CHYGO1985
 * @history Oct 8, 2020
 * 
 * ref: https://leetcode.com/problems/number-of-digit-one/solution/
 * 
 */
class Solution {
    public int countDigitOne(int n) {
        
        int count = 0;
        
        for (int base = 1; base <= n; base = base * 10) {
            
            int dividend = base * 10;
            
            // max: in case that Math.max((n % dividend) - base + 1 < 0, for example, 107 % 100 - 10 + 1 < 0
            // min: for example, 27 % 100 - 10 + 1 = 28, which is not right, it should be 10 (10 ... 19) 
            count += (n / dividend) * base + Math.min(Math.max((n % dividend) - base + 1, 0), base);
        }
        
        return count;
    }
}