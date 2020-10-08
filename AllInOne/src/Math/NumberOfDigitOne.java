/**
 * 
 * 233. Number of Digit One
 * 
 * @CHYGO1985
 * @history Oct 8, 2020
 * 
 */
class Solution {
    public int countDigitOne(int n) {
        
        int count = 0;
        
        for (int base = 1; base <= n; base = base * 10) {
            
            int dividend = base * 10;
            
            // max: in case that Math.max((n % dividend) - base + 1 < 0, for example, 107 % 100 - 10 + 1 < 0
            count += (n / dividend) * base + Math.min(Math.max((n % dividend) - base + 1, 0), base);
        }
        
        return count;
    }
}