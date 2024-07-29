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
var maxAncestorDiff = function (root) {
  let maxDiff = 0;

  // console.log(maxDiff)
  if (!root || (!root.left && !root.right)) {
    return maxDiff;
  }

  const findAncesterDiff = (ancester, curNode) => {
    if (!curNode) return;

    maxDiff = Math.max(maxDiff, Math.abs(ancester.val - curNode.val));

    findAncesterDiff(ancester, curNode.left);
    findAncesterDiff(ancester, curNode.right);
  };

  traverseTree = (root) => {
    if (!root || (!root?.left && !root?.right)) {
      return;
    }

    findAncesterDiff(root, root.left);
    findAncesterDiff(root, root.right);

    traverseTree(root.left);
    traverseTree(root.right);
  };

  traverseTree(root);

  return maxDiff;
};
