
/**
 * round 1: solved, 40m, 7ms, beat 39%, flag method, use rowPos and colPos to record the max value position
 * 
 * @author jingjiejiang
 * @history Jun 8, 2017
 */
public class RangeAdditionII {
	 
    public int maxCount(int m, int n, int[][] ops) {
        
        int rowMaxPos = Integer.MAX_VALUE;
        int colMaxPos = Integer.MAX_VALUE;
        
        //*** edge case: return m * n
        if (null == ops || 0 == ops.length || 0 == ops[0].length) return m * n;
        
        /*
        for (int[] op : ops) {
            // *** rang need to - 1
            rowMaxPos = Math.min(op[0] - 1, rowMaxPos);
            colMaxPos = Math.min(op[1] - 1, colMaxPos);
        }
        
        return (colMaxPos + 1) * (rowMaxPos + 1);
        */
        
        // refactor: do not need to - 1 and then + 1
        for (int[] op : ops) {
            // *** rang need to - 1
            rowMaxPos = Math.min(op[0], rowMaxPos);
            colMaxPos = Math.min(op[1], colMaxPos);
        }
        
        return (colMaxPos) * (rowMaxPos);
    }
}
