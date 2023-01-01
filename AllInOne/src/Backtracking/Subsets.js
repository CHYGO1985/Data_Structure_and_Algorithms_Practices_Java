/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
  
  if (!nums || nums.length < 1) return undefined;

  const res = [];
  const getSubSet = (nums, cur, begin) => {
    res.push([...cur]); 

    for (let idx = begin; idx < nums.length; idx ++) {
      cur.push(nums[idx]);
      getSubSet(nums, cur, idx + 1);
      cur.pop();
    }
  };

  getSubSet(nums, [], 0);
  return res;
};