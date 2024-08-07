/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
  nums.sort((a, b) => a - b)

  const res = []
  const getSubests = (nums, curSet, curIdx) => {
      res.push([...curSet])

      for (let idx = curIdx; idx < nums.length; idx ++) {
          if (idx > curIdx && nums[idx] === nums[idx - 1]) {
              continue
          }

          curSet.push(nums[idx])
          getSubests(nums, curSet, idx + 1)
          curSet.pop()
      }
  }

  getSubests(nums, [], 0)
  return res
};