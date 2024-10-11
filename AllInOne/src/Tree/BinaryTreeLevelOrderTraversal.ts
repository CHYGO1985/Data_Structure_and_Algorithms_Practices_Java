/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     val: number
 *     left: TreeNode | null
 *     right: TreeNode | null
 *     constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.left = (left===undefined ? null : left)
 *         this.right = (right===undefined ? null : right)
 *     }
 * }
 */

class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
    this.val = val === undefined ? 0 : val;
    this.left = left === undefined ? null : left;
    this.right = right === undefined ? null : right;
  }
}

function levelOrder(root: TreeNode | null): number[][] {
  const res: number[][] = new Array();

  const buildLevelOrderArray = (
    root: TreeNode | null,
    res: number[][],
    depth: number
  ) => {
    if (!root) return;

    if (!res.length || res.length < depth) {
      res[depth - 1] = new Array();
    }

    res[depth - 1].push(root.val);

    buildLevelOrderArray(root.left, res, depth + 1);
    buildLevelOrderArray(root.right, res, depth + 1);
  };

  buildLevelOrderArray(root, res, 1);

  return res;
}
