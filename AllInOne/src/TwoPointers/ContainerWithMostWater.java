/**
 * 
 * 11. Container With Most Water
 * 
 * @author jingjiejiang
 * @history May 6, 2021
 * 
 */
public class ContainerWithMostWater {
    // public int maxArea(int[] height) {
        
    //     assert height != null;

    //     int maxArea = 0, left = 0, right = height.length - 1;

    //     while (left < right) {

    //         maxArea = Math.max(maxArea, Math.min(height[right], height[left]) * (right - left));
    //         if (height[left] < height[right]) {
    //             left ++;
    //         } else {
    //             right --;
    //         }
    //     }

    //     return maxArea;
    // }

    public int maxArea(int[] height) {
        
      assert height != null && height.length >= 1;

      int max = 0;

      for (int left = 0, right = height.length - 1; left <= right;) {
        
        max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
        if (height[left] >= height[right]) {
          right --;
        } else {
          left ++;
        }
      }

      return max;
    }
}
