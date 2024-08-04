/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */

/**
 * Encodes a tree to a single string.
 *
 * @param {TreeNode} root
 * @return {string}
 */
var serialize = function (root) {
  if (!root) return '#!';

  let res = root.val + '!';

  res += serialize(root.left);
  res += serialize(root.right);

  return res;
};

var getTree = function (dataArr) {
  const curValue = dataArr.shift();

  if (curValue === '#') return null;

  const root = new TreeNode(parseInt(curValue));

  root.left = getTree(dataArr);
  root.right = getTree(dataArr);

  return root;
};

/**
 * Decodes your encoded data to tree.
 *
 * @param {string} data
 * @return {TreeNode}
 */
var deserialize = function (data) {
  if (!data || data.length === 0) return null;
  return getTree(data.split('!'));
};

/**
 * Your functions will be called as such:
 * deserialize(serialize(root));
 */
