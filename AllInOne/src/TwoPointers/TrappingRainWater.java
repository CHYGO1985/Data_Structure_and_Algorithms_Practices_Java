import java.util.Stack;

/**
 * 
 * 42. Trapping Rain Water
 * 
 * @author jingjiejiang
 * @history Apr 29, 2021
 * 
 */
public class TrappingRainWater {
    
    public int trap1(int[] height) {

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

    public int trap(int[] height) {
        
        if (height == null) return 0;
         
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;

        while (i < height.length){
            if (s.isEmpty() || height[i] <= height[s.peek()]){
                 s.push(i++);
            }
            else {
                 int bot = s.pop();
                 maxBotWater = s.isEmpty()? // empty means no il
                 0 : (Math.min(height[s.peek()], height[i]) - height[bot]) * (i - s.peek() - 1);
                 maxWater += maxBotWater;
            }
        }

        return maxWater;
     }
}
