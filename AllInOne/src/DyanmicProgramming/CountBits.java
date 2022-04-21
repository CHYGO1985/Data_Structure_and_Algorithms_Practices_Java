package DyanmicProgramming;

/**
 * 
 * 338. Counting Bits
 * 
 * @author jingjiejiang
 * @history Apr 21, 2022
 * 
 */
public class CountBits {
  public int[] countBits(int n) {
        
    assert n >= 0 && n < Math.pow(10, 5);
    
    int[] res = new int[n + 1];
    res[0] = 0;
    
    for (int idx = 1; idx <= n; idx ++) {
        
        int hasOne = idx & 1;
        
        if (hasOne == 1) {
            res[idx] = 1 + res[idx - 1];
        } else {
            res[idx] = res[idx / 2];
        }
    }
    
    return res;
  }
}
