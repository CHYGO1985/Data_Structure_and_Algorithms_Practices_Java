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

  /*                       
          1  3  5  5  9  9  9    original sorted inventory
          1  3  5  5  5  5  5    profit gain after selling all 9-value balls: (9 + 8 + 7 + 6) * 3 -> (9 + 6) * (9 - 6 + 1) / 2 * 3
          1  3  3  3  3  3  3    (5 + 4) * (5 - 4 + 1) / 2 * 5  -> (curValue + nextValue + 1) * (curValue - nextValue) / 2 * numSameColor
          1  1  1  1  1  1  1
          0  0  0  0  0  0  0
          
          need to handle the edge case that orders left is less than the number of items to buy

          for example: 5 9 9 9, the order is 8
          then we shoudl get: 9 9 9
                              8 8 8
                                7 7
  */
}
