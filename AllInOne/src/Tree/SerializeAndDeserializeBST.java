import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.tree.TreeNode;

import jdk.nashorn.api.tree.Tree;

/**
 * 
 * 449. Serialize and Deserialize BST
 * 
 * @author jingjiejiang
 * @history Oct 10, 2020
 * 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "#!";
        
        String nodeStr = root.val + "!";

        nodeStr += serialize(root.left);
        nodeStr += serialize(root.right);

        return nodeStr;
    }

    private TreeNode getTree(List<String> valList) {

        String curValStr = valList.remove(0);

        if (curValStr.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(curValStr));

        root.left = getTree(valList);
        root.right = getTree(valList);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if (data == null || data.length() == 0) return null;

        return getTree(new ArrayList<>(Arrays.asList(data.split("!"))));
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

/**
 * 
 * 449. Serialize and Deserialize BST
 * 
 * @author jingjiejiang
 * @history Oct 10, 2020
 * 
 */