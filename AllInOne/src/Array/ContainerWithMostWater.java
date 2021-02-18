/**
 * 
 * 11. Container With Most Water
 * 
 * @author jingjiejiang
 * @history Feb 18, 2021
 * 
 */
class Solution {
    public int maxArea(int[] height) {

        assert height != null;

        int maxArea = 0, left = 0, right = height.length - 1;

        while (left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));

            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }

        return maxArea;
    }
}