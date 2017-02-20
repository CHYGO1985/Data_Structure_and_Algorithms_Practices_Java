import java.util.LinkedList;
import java.util.Queue;


public class SeriAndDesBiTree {
	
	// idea: method 1: BFS - layer traverse
    // https://discuss.leetcode.com/topic/31264/short-and-straight-forward-bfs-java-code-with-a-queue
    // 1) serialise: 
    // a. use queue
    // b. empty node insert 'n'
    // c. use StringBuilder
    // 2) deserialise:
    // a. use queue
    // result: 27ms. beat 55.07%
    // --> improve serialise method
    
    // method 2: pre-order
    // https://discuss.leetcode.com/topic/28029/easy-to-understand-java-solution/2
    
    // *** things learned: 1) integer to string / string to integer function
    // 2) methods in Queue
    // 3) methods in String
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (null == root) {
            return "";
        }
        
        StringBuilder builder = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        
        /*
        builder.append(root.val).append("#");
        // use isEmpty() == false or null == poll()
        while (false == queue.isEmpty()) {
            TreeNode temp = queue.poll();
           
            if (temp.left != null) {
                queue.add(temp.left);
                builder.append(temp.left.val).append("#");
            }
            else {
                builder.append("n").append("#");
            }
            
            if (temp.right != null) {
                queue.add(temp.right);
                builder.append(temp.right.val).append("#");
            }
            else {
                builder.append("n").append("#");    
            }
        }
        */
        
        // improve
        while (false == queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if (temp != null) {
                builder.append(temp.val).append("#");
            }
            else {
                builder.append("n").append("#");
                continue;
            }
            
            queue.add(temp.left);
            queue.add(temp.right);
        }
        
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
        if ("" == data) {
            return null;
        }
        
        String[] vals = data.split("#");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        queue.add(root);
        
        for (int index = 1; index < vals.length; index ++) {
            
            TreeNode parent = queue.poll();
            
            // *** String compare use equals, do not use ==
            if (false == vals[index].equals("n")) {
                TreeNode left = new TreeNode(Integer.valueOf(vals[index]));
                parent.left = left;
                queue.add(left);
            }
            index ++;
            if (index < vals.length && false == vals[index].equals("n")) {
                TreeNode right = new TreeNode(Integer.valueOf(vals[index]));
                parent.right = right;
                queue.add(right);
            }
        }
        
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
