/**
 * 
 * 933. Number of Recent Calls
 * 
 * @author jingjiejiang
 * @history Oct 2, 2020
 * 
 */
class RecentCounter {

    private Deque<Integer> queue;
    
    public RecentCounter() {
        
        queue = new ArrayDeque<>();
    }
    
    public int ping(int t) {
        
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.pollFirst();
        }
        
        queue.offer(t);
        
        return queue.size();
    }
}