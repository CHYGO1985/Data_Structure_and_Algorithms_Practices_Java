/**
 * 
 * 1007. Minimum Domino Rotations For Equal Row
 * 
 * @author jingjiejiang
 * @history Oct 20, 2020
 * 
 */
class Solution {
  public int minDominoRotations(int[] A, int[] B) {
      
    if (A == null || B == null || A.length != B.length) return -1;
        
    // check if a dice num cover a row, if not return -1, means not possible to get the same num
    // the extra num is to record the total presence of the number
    int[][] diceRowMap = new int[6][A.length + 1];
    
    // count the total presence of each number for A and B
    // 0: A  1: B
    int[][] count = new int[6][2];
    
    for (int idx = 0; idx < A.length; idx ++) {
     
        if (diceRowMap[A[idx] - 1][idx] == 0) {
            diceRowMap[A[idx] - 1][idx] = 1;
            count[A[idx] - 1][0] += 1;
            
            // if at idx, A and B has the same dice num, then both count should add 1 
            if (A[idx] == B[idx]) count[A[idx] - 1][1] += 1;
            
            // if A[idx] = b[idx], then should only add once
            diceRowMap[A[idx] - 1][A.length] += 1;
    
        }
        
        // if A[idx] = B[idx], then previous if will set diceRowMap[B[idx] - 1][idx] as 1
        if (diceRowMap[B[idx] - 1][idx] == 0) {
           diceRowMap[B[idx] - 1][idx] = 1;
           count[B[idx] - 1][1] += 1;
           diceRowMap[B[idx] - 1][A.length] += 1;
        }
    }

    for (int idx = 0; idx < 6; idx ++) {
        
        if (diceRowMap[idx][A.length] == A.length) {
            // if (Math.max(count[diceNum][0], count[diceNum][1]) > maxCnt) {
            //     maxCnt = diceRowMap[idx][A.length];
            //     diceNum = idx;
            // }
            return A.length - Math.max(count[idx][0], count[idx][1]);
        }
    } 
    
    return -1;
  }
}