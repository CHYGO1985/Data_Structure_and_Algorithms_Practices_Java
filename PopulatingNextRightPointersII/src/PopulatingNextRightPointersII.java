import java.util.LinkedList;
import java.util.List;


public class PopulatingNextRightPointersII {
	
	// idea: use "next" as the source to traverse the tree
    // result: 1ms, beat 50.32%, fastest is 1ms
	
	public static class TreeLinkNode {
	    int val;
	    TreeLinkNode left, right, next;
	    TreeLinkNode(int x) { val = x; }
	}
	
	public static TreeLinkNode buildBiTreeByArray(int[] nums) {
		
		int total = nums.length;
		
		if (0 == total) {
			return null;
		}
		
		TreeLinkNode root = new TreeLinkNode(nums[0]);
		List<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
		list.add(root);
		int count = 1;
		
		while (list.size() > 0 && count < total) {
		
			int curSum = list.size();
			
			while (curSum > 0 && count < total) {
				
				TreeLinkNode temp = list.get(0);
				list.remove(0);
				
				if (count < total) {
					
					if (nums[count] != -1) {
						temp.left = new TreeLinkNode(nums[count]);
						list.add(temp.left);
					}
					count ++;
				}
				
				if (count < total) {
					
					if (nums[count] != -1) {
						temp.right = new TreeLinkNode(nums[count]);
						list.add(temp.right);
					}
					count ++;
				}
				curSum --;
			}
		}
		
		return root;
	}
	
	public static void connect(TreeLinkNode root) {
        
		if (null == root) {
	            return ;
        }
        
		TreeLinkNode nextBeginNode = root;
        TreeLinkNode parent = root;
        while (nextBeginNode != null) {
            if (nextBeginNode.left != null) {
            	parent = nextBeginNode;
                nextBeginNode = nextBeginNode.left;
                buildNext(nextBeginNode, parent);
            }
            else if (nextBeginNode.right != null) {
                parent = nextBeginNode;
                nextBeginNode = nextBeginNode.right;
                buildNext(nextBeginNode, parent);
            }
            else {
            	nextBeginNode = nextBeginNode.next;
			}
        }
    }
	
	public static void buildNext(TreeLinkNode root, TreeLinkNode parent) {
        
		if (null == root) {
            return ;
        }
        
        // first search for right sibling
        if (parent != null) {
            if (parent.right != null && parent.right != root) {
                root.next = parent.right;
            }
            else  {
                TreeLinkNode temp = parent.next;
                while (temp != null) {
                    // search for the next of parent
                    if (temp.left != null) {
                        root.next = temp.left;
                        parent = temp;
                        break;
                    }
                    else if (temp.right != null) {
                        root.next = temp.right;
                        parent = temp;
                        break;
                    }
                    else {
                    	temp = temp.next;
                    }
                }
            }
            
            buildNext(root.next, parent);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		TreeLinkNode root = new TreeLinkNode(1);
		TreeLinkNode node2 = new TreeLinkNode(2);
		TreeLinkNode node3 = new TreeLinkNode(3);
		TreeLinkNode node4 = new TreeLinkNode(4);
		TreeLinkNode node5 = new TreeLinkNode(5);
		TreeLinkNode node6 = new TreeLinkNode(6);
		TreeLinkNode node7 = new TreeLinkNode(7);
		TreeLinkNode node8 = new TreeLinkNode(8);
		root.left = node2;
		root.right = node3;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.right = node6;
		node6.right = node8;
		
		node4.left = node7;
		*/
		
		int[] arr = {0,2,4,1,-1,3,-2,5,1,-1,6,-1,8};
		TreeLinkNode root = buildBiTreeByArray(arr);
		connect(root);

	}

}
