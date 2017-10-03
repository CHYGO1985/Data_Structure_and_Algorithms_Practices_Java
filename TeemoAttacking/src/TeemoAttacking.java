/**
 * 
 * 495. Teemo Attacking
 * 
 * round 1: solved, 30m, 1 attemps
 * 
 * idea: range merge problem -> flag method
 * flag: start point startPoint and intermediate end point endPoint
 * check the current start point curStart with endPoint
 * 1) if curStart > endPoint, add previous endPoint - startPoint + 1
 * 2) if curStart <= endPoint, update endPoint
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 3, 2017
 */
public class TeemoAttacking {
	
	// round 1: solved, 30m, 1 attemps
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // merge (merge internvals)
        
        if (null == timeSeries || 0 == timeSeries.length || 0 == duration)
            return 0;
        
        int start = 0;
        int limit = -1;
        int sum = 0;
        for (int time : timeSeries) {
           
            // time > previous poisoned time, update sum, current start time 
            if (time > limit) {
                sum += limit - start + 1;
                start = time;
                limit = time + duration - 1;
            }
            // time <= limit
            else { 
                limit = Math.max(limit, time + duration - 1);
            }
        }
        
        // if (count != 0 && start + count - 1 >= limit)
        sum += limit - start + 1;
        
        return sum;
    }

}
