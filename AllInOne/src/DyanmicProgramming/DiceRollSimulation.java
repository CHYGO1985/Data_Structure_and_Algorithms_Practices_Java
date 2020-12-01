/**
 * 
 * 1223. Dice Roll Simulation
 * 
 * @CHYGO1985
 * @history Nov 30, 2020
 *
 */
class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        
        long divisor = (long) Math.pow(10, 9) + 7;
        // n is the num of rolls, and 7 is 6 nums(idx:0 -5) + sum(idx:6)
        long[][] dp = new long[n][7];
    }
}