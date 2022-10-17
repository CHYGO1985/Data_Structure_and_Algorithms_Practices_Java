/**
 * 
 * 26. Remove Duplicates from Sorted Array
 * 
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
  if (!nums) {``
    return -1;
  }   
  
  let insertIdx = 1;

  for (let idx = 1; idx < nums.length; idx ++) {
    if (nums[idx - 1] != nums[idx]) {
      nums[insertIdx] = nums[idx];
      insertIdx ++;
    }
  }

  return insertIdx;
};
