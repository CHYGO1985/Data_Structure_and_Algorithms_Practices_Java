/**
 * 
 * 518. Coin Change 2
 * 
 * @CHYGO1985
 * @history Sep 20, 2020 
 *  
 */
class Solution {
    public int change(int amount, int[] coins) {
        
        if (coins == null) return 0;
       
        int[] changes = new int[amount + 1];
        Arrays.fill(changes, 0);
        changes[0] = 1;
        
        for (int coin : coins) {
            for (int sum = 1; sum <= amount; sum ++) {

                if (sum < coin) continue;
                changes[sum] = changes[sum] + changes[sum - coin];
            }
        }
        
        return changes[amount];
    }
}