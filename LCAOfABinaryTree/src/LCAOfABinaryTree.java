
import java.util.HashMap;
import java.util.Map;

public class LCAOfABinaryTree {
	
	public static class TreeNode {
        int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x, TreeNode left, TreeNode right) { 
			val = x;
			this.left = left;
			this.right = right;
		}
    }

	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		
		/*
		// method 2: https://discuss.leetcode.com/topic/18561/4-lines-c-java-python-ruby/7
        // result: 11ms, 30.09%,  beat 63.81%, fastest is 9ms
            if (root == null || root == p
                || root == q) return root;
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left == null ? right : right == null ? left : root;
         */   
         
        // Idea: post-order traverse + Hash Map (easy to find match in hash map)
        // 1) common ancestor --> need ancestors infor --> need to keep the infor when traverse
        // 2) pre-order and in-order are not suitable to keep ancestor infor
        
        // handle root == null
        if (null == root) {
            return root;
        }
        
        // Integer store layer information
        Map<Integer, TreeNode> mapP = new HashMap<Integer, TreeNode>(); 
        Map<Integer, TreeNode> mapQ = new HashMap<Integer, TreeNode>();
        
        TreeNode tempRoot = root;
        boolean hasMatch = false;
        hasMatch = postOrderSearch(tempRoot, 1, mapP, p);
        
        if (false == hasMatch) {
            return root;
        }
        
        tempRoot = root;
        hasMatch = postOrderSearch(tempRoot, 1, mapQ, q);
        
        if (false == hasMatch) {
            return root;
        }
        
        // if can find both p and q in the tree, compare the lost, otherwise return root
        TreeNode lca = root;
        
        for (Map.Entry<Integer, TreeNode> entry: mapP.entrySet()) {
            
            int key = entry.getKey();
            if (false == mapQ.containsKey(key)) {
                break;
            }
            else {
                
                TreeNode tempP = entry.getValue();
                TreeNode tempQ = mapQ.get(key);
                if (tempP.val == tempQ.val && tempP.left.val == tempQ.left.val
                    && tempP.right.val == tempQ.right.val) {
                    lca = tempP;    
                }
            }
        }
        
        return lca;
    }
    
    // post-order traverse
    public static boolean postOrderSearch(TreeNode node, int layer, Map<Integer, TreeNode> map,
        TreeNode compNode) {
        
        if (null == node) {
            return false;
        }
        else if (true == isTreeNodeEqual(node, compNode)) {
        	map.put(layer, node);
            return true;
        }
        else {
            map.put(layer, node);
        }        
        // 1.add current node to the stack, then check left child and right child
        // layer + 1 means current layer count +1, ++ for right child
        boolean hasMatch = postOrderSearch(node.left, (layer ++) + 1, map, compNode);
        
        if (true == hasMatch) {
            return true;
        }
        else {
        	map.remove(layer, node.left);
            hasMatch = postOrderSearch(node.right, layer, map, compNode);
        }
        
        // 3. if not match for left and right child, pop the top node from the stack
        if (false == hasMatch) {
            map.remove(layer);
            layer --;
            return false;
        }
        else {
            return true;
        }
    }
    
    public static boolean isTreeNodeEqual(TreeNode m, TreeNode n) {
    	
    	if (null == m && null == n) {
    		return true;
    	}
    	else if (null == m || null == n){
    		return false;
    	}
    	else if (m.val == n.val ) {
    		return isTreeNodeEqual(m.left, n.left) &&
    				isTreeNodeEqual(m.right, n.right);
    	}
    	else {
    		return false;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node8 = new TreeNode(8, null, null);
        TreeNode node0 = new TreeNode(0, null, null);
        
        TreeNode node2 = new TreeNode(2, node7, node4);
        TreeNode node5 = new TreeNode(5, node6, node2);
        TreeNode node1 = new TreeNode(1, node0, node8);
        TreeNode root = new TreeNode(3, node5, node1);
        */
		TreeNode noden100 = new TreeNode(-100, null, null);
		TreeNode noden101 = new TreeNode(-100, null, null);
		TreeNode noden71 = new TreeNode(-71, null, null);
		TreeNode node8 = new TreeNode(8, null, null);
		
		TreeNode noden12 = new TreeNode(-12, null, node8);
		TreeNode noden54 = new TreeNode(-54, noden71, noden12);
		TreeNode node48 = new TreeNode(48, noden54, null);
		TreeNode noden48 = new TreeNode(-48, noden101, node48);
		TreeNode noden34 = new TreeNode(-34, null, noden100);
		TreeNode root = new TreeNode(37, noden34, noden48);
	
		
        TreeNode p = new TreeNode(-100, null, null);
        TreeNode q = new TreeNode(-71, null, null);
        
        TreeNode lcaNode = lowestCommonAncestor(root, p, q);
        
	}

}
