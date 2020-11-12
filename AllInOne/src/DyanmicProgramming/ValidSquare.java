import java.util.Arrays;

/**
 * 
 * 593. Valid Square
 * 
 * @CHYGO1985
 * @history Nov 12, 2020
 * 
 */
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        
        Set<Integer> lenSet = new HashSet<>(Arrays.asList(getLen(p1, p2), getLen(p2, p2),
            getLen(p3, p4), getLen(p4, p1), getLen(p1, p3), getLen(p2, p4)));

        // for 0 it can be [0,0],[1,1],[0,0],[0,0]    
        return !lenSet.contains(0) && lenSet.size() == 2;
    }

    private int getLen(int[] p1, int[] p2) {
        return Math.pow((p1[0] - p2[0]), 2) + Math.pow((p[1] - p2[1]), 2); 
    }
}