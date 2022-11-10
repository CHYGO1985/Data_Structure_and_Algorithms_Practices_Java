/**
 * 
 * 46. Permutations
 * 
 */
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
 var permute = function(nums) {

    const result = [];
    const used = new Array(nums.length).fill(false);

    const backtrack = (nums, path) => {
      if (path.length >= nums.length) {
        result.push([...path]);
        return ;
      }

      for (let idx = 0; idx < nums.length; idx ++) {
        if (used[idx]) continue;

        path.push(nums[idx]);
        used[idx] = true;
        backtrack(nums, path);
        path.pop();
        used[idx] = false;
      }
    };

    backtrack(nums, []);

    return result;
};