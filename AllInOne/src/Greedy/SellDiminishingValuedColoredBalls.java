import java.math.BigInteger;
import java.util.PriorityQueue;

/**
 * 
 * 1648. Sell Diminishing-Valued Colored Balls
 * 
 * @author jingjiejiang
 * @history Oct 21, 2021
 * 
 * ref: https://leetcode.com/problems/sell-diminishing-valued-colored-balls/discuss/1116418/Java-sorting-solution-or-easy-to-understand-or-O(nlogn)
 * 
 */
public class SellDiminishingValuedColoredBalls {
  // time limit exceeded solution
  public int maxProfit(int[] inventory, int orders) {
        
    assert inventory.length >= 1 && inventory.length <= 1e5 && orders >= 1;

        BigDecimal sum = BigDecimal.valueOf(0);
        BigDecimal divisor = BigDecimal.valueOf(1e9 + 7); 

        PriorityQueue<Integer> inventQueue = new PriorityQueue<>(
            (a, b) -> b - a);
        
        for (int item : inventory) {
            inventQueue.offer(item);
        }

        while (orders > 0) {

          int curInvent = inventQueue.poll();
          // add current inventory
          sum = sum.add(BigDecimal.valueOf(curInvent));
          // add the new inventory num to the queue
          inventQueue.offer(curInvent - 1);
          orders --;
        }

        return sum.remainder(divisor).intValue();
  }
}
