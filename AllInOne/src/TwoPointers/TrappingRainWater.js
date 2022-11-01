/**
 * 
 * 42. Trapping Rain Water
 * 
 */
/**
 * @param {number[]} height
 * @return {number}
 */
 var trap = function(height) {
    
  if (!height) return undefined;

  let sum = 0, left = 0, right = height.length - 1;

  while (left < right) {

    const min = Math.min(height[left], height[right]);
    
    if (min === height[left]) {
      while (left < right && min >= height[++ left]) {
        sum += (min - height[left]);
      }
    } else {
      while (left < right && min >= height[-- right]) {
        sum += (min - height[right]);
      }
    }
  }

  return sum;
};