package src.Math;

/**
 * 
 * 829. Consecutive Numbers Sum
 * 
 * @author jingjiejiang
 * @history Apr 26, 2022
 * 
 */
public class ConsecutiveNumbersSum {
  public int consecutiveNumbersSum(int n) {
        
    assert n >= 1;
    
    int count = 0;
    int upperLimit = (int) (Math.sqrt(2*n + 0.25) - 0.5);
    
    for (int num = 1; num <= upperLimit; num ++) {
        if ((n - num*(num + 1) / 2) % num == 0)
            count ++;
    }
    
    return count;
  }
}
