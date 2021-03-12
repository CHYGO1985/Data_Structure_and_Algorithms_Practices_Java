/**
 * 
 * 322. Coin Change
 * 
 * @CHYGO1985
 * @history Sep 20, 2020
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
         
        if (coins == null || coins.length == 0 || amount == 0) return 0;

          int[] changes = new int[amount + 1];
          Arrays.fill(changes, amount + 1);
          changes[0] = 0;

          for (int idx = 1; idx < changes.length; idx ++) {
            for (int coin : coins) {
              if (coin <= idx) {
                changes[idx] = Math.min(changes[idx], 1 + changes[idx - coin]);
              }
            }
          }

           // cannot use changes[amount] == amount for test case [2] 3
          return changes[amount] > amount ? -1 : changes[amount];
    }
}