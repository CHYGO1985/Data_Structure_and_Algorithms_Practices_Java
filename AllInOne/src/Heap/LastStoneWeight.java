import java.util.PriorityQueue;

/**
 * 
 * 1046. Last Stone Weight
 * 
 * @author jingjiejiang
 * @history Feb 4, 2021
 * 
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

        for (int stone : stones) 
            queue.offer(stone);

        while (queue.size() > 1) {
            queue.offer(queue.poll() - queue.poll());
        }

        return queue.poll();
    }
}