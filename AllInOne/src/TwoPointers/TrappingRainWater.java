/**
 * 
 * 42. Trapping Rain Water
 * 
 * @author jingjiejiang
 * @history Apr 29, 2021
 * 
 */
public class TrappingRainWater {
    public int trap(int[] height) {

        assert height != null;

        int left = 0, right = height.length - 1, sum = 0;

        while (left < right) {
            
            int min = Math.min(height[left], height[right]);

            if (min == height[left]) {

                while (left < right && height[++ left] <= min) {
                
                    sum += (min - height[left]);
                } 
            } else {

                while (left < right && height[-- right] <= min) {
                    
                    sum += (min - height[right]);
                }
            }
        }

        return sum;
    }
}
