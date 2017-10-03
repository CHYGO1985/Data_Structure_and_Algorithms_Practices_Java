/**
 * 
 * 11. Container With Most Water
 * 
 * round 1: solved, 2 attemps, 40m
 * 
 * idea: the max container depends on the min height of two ends and width
 * so --> use two pointers from different ends to check all the possible
 * container from max width (0 to n - 1) to the max of min height 
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 3, 2017 
 */
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
        // not a good question, should put a graph to help understanding
        if (null == height || 0 == height.length) return 0;
        
        int left = 0; 
        int right = height.length - 1;
        
        int h = Integer.MAX_VALUE;
        int max = 0;
        
        while (left < right) {
            h = Math.min(height[left], height[right]);
            max = Math.max(max, h * (right - left));
            while(height[left] <= h && left < right) left ++;
            while (height[right] <= h && left < right) right --;
        }
        
        return max;
    }
}
