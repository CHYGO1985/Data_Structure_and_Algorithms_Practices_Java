package src.Greedy;

/**
 * 2340. Minimum Adjacent Swaps to Make a Valid Array
 */
public class MiniAdjacentSwapsToMakeAValidArray {
  public int minimumSwaps(int[] nums) {
        int max = -1, min = Integer.MAX_VALUE, maxIndex = 0, minIndex = 0;
        
        for(int i = 0; i < nums.length; i++) {
            // use < , so we get the leftmost min
            if(nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            // use >= , so we get the rightmost max
            if(nums[i] >= max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        // If this is true, then we need to swap places with the max number and min number
        // which means that the min number will need one less swap to reach the start of the array
        // as in the process of swapt min to left, the max will move right one more step, so minus one
        if(minIndex > maxIndex) {
            minIndex--;
        }
        
        // nums.length - 1 is the last ele
        return (nums.length - 1 - maxIndex) + minIndex;
    }
}
