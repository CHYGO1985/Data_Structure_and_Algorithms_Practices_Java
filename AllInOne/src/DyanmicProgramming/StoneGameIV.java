/**
 * 
 * 1510. Stone Game IV
 * 
 * @CHYGO1985
 * @history Oct 25, 2020
 * 
 */
class Solution {
    public boolean winnerSquareGame(int n) {
        
        // res[i] means at i stones, the player platys first can win or not
        boolean[] res = new boolean[n + 1];
         
        // when there are no stone, the player plays first will lost the game
        res[0] = false;

        for (int stones = 1; stones <= n; stones ++) {
            for (int k = 1; k * k <= stones; k ++) {
                if (!res[stones - k * k]) {
                    res[stones] = true;
                    break;
                }
            }
        } 

        return res[n];
    }
}
