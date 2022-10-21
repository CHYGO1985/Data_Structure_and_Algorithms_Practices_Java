/**
 * 
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * @history Oct 21, 2022
 * 
 */
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var searchRange = function(nums, target) {
    
  const findLeftBoundry = (nums, target) => {
      let left = 0, right = nums.length;
      
      while (left < right) {
          const mid = left + parseInt((right - left) / 2);
          
          if (nums[mid] < target) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      
      return left;
  };
  
  const startPos = findLeftBoundry(nums, target);
  
  if (startPos == nums.length || nums[startPos] != target) return [- 1, - 1];
  
  return [startPos, findLeftBoundry(nums, target + 1) - 1];
};