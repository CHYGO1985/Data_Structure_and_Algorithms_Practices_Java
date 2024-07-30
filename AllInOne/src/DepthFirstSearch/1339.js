/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var maxProduct = function (root) {
  const sums = new Array();

  const treeSum = (root) => {
    if (!root) return 0;

    const leftSum = treeSum(root.left);
    const rightRum = treeSum(root.right);

    const totalSum = leftSum + rightRum + root.val;
    sums.push(totalSum);

    return totalSum;
  };

  let res = 0;
  const totalSum = treeSum(root);
  for (let sum of sums) {
    res = Math.max(res, sum * (totalSum - sum));
  }
  // can only modular at the end, e.g. [1,2,3], 3 is the max but if %3, 3 % 3 = 0, that is the min
  return res % (1e9 + 7);
};
