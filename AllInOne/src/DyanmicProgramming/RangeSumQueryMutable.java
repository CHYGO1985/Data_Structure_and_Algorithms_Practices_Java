/**
 * 
 * 307. Range Sum Query - Mutable
 * 
 * @CHYGO1985
 * @history Oct 23, 2020
 * 
 */
class NumArray {

    private int[] preSums;

    public NumArray(int[] nums) {
        
        preSums = nums;
        
        for (int idx = 1; idx < preSums.length; idx ++) {
            preSums[idx] = preSums[idx] + preSums[idx - 1];
        }
    }
    
    public void update(int i, int val) {

        int dif = (preSums[i] - (i > 0 ? preSums[i - 1] : 0)) - val;
        
        for (int idx = i; idx < preSums.length; idx ++) {
            
            preSums[idx] -= dif;
        }
    }
    
    public int sumRange(int i, int j) {
    
        return preSums[j] - (i > 0 ? preSums[i - 1] : 0);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */