import java.util.PriorityQueue;

/**
 * 
 * 1167. Minimum Cost to Connect Sticks
 * 
 * @author jingjiejiang
 * @history Oct 20, 2021
 * 
 * Greedy : priority queue
 * 
 */
public class MinCostToConnectSticks {
  public int connectSticks(int[] sticks) {
        
    assert sticks.length >= 1 && sticks.length <= 1e4;
    
    PriorityQueue<Integer> numPriQueue = new PriorityQueue<>();

    for (int stick : sticks) {
      numPriQueue.offer(stick);
    }

    int minCost = 0;

    while (numPriQueue.size() > 1) {
      
      int sum = numPriQueue.poll() + secnumPriQueue.poll();
      minCost += sum;
      numPriQueue.offer(sum);
    }

    return minCost;
  }
}
