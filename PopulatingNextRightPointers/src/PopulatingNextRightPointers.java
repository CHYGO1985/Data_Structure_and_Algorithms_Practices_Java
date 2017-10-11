import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 116. Populating Next Right Pointers in Each Node
 * 
 * round 2: unsolved, 40m, recursive method
 * idea: how to design tree recursive process:
 * 1) start with 3 nodes, only 2 layers
 * 2) extend to 3 layers full tree, see whether the method still work
 * 3) extend the tree to 4 layer and see method get from 2) can work or not
 * 
 * recursive method:
 * http://algorithms.tutorialhorizon.com/provide-the-next-siblings-pointers-in-a-given-binary-tree/
 * 
 * @author jingjiejiang
 * @history
 * 1. round 2. Oct 11, 2017
 */
public class PopulatingNextRightPointers {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	
	
	// recursive method
	/*
	public void connect(TreeLinkNode root) {

		if (null == root)
			return;
		root.next = null;
		buildConnect(root);
	}

	private void buildConnect(TreeLinkNode root) {

		if (root == null)
			return;

		if (root.left != null)
			root.left.next = root.right;
		if (root.next != null && root.right != null)
			root.right.next = root.next.left;

		buildConnect(root.left);
		buildConnect(root.right);
	}
    */
	
	// level order traverse
	public void connect(TreeLinkNode root) {
        
        // method 2: preorder (to build layer infor) to assign each next
        // space: need a List<List>
        // result: 3ms, beat 20%
        if (null == root) {
            return ;
        }
        
        List<List<TreeLinkNode>> list = new LinkedList<List<TreeLinkNode>>();
        
        buildNext(root, list, 0);
    }
    
    public void buildNext(TreeLinkNode root, List<List<TreeLinkNode>> list, int layer) {
        
        if (null == root) {
            return ;
        }
        
        // if it is a new layer
        if (list.size() <= layer) {
            
            List<TreeLinkNode> curList = new LinkedList<TreeLinkNode>();
            list.add(curList);
        }
        
        // get the list at i
        List<TreeLinkNode> temp = list.get(layer);
        // get the last node of cur layer list
        if (temp.size() > 0) {
            TreeLinkNode preNode = temp.get(temp.size() - 1);
            preNode.next = root;
        }
        
        temp.add(root);
        
        buildNext(root.left, list, layer + 1);
        buildNext(root.right, list, layer + 1);
    }

}
