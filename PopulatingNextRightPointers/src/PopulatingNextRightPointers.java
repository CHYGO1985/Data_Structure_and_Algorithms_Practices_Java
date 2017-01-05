import java.util.LinkedList;
import java.util.List;


public class PopulatingNextRightPointers {
	
	public class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
    
	public void connect(TreeLinkNode root) {
        // idea: similar to zigzag traverse
        // method 1: traditional layer order traverse to assign each next
        // space: need one list, size = nodes count / 2.
        
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
