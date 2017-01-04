
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntPredicate;


public class ConsBTFromInAndPostorderTra {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// method 2: used a hashmap to store the position of inorder, so do not need to iterate through inorder to
    // find the root everytime.
    // ref: https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space/2
    // result: 5ms, beat 75.85%
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if (inorder == null || postorder == null || inorder.length != postorder.length)
    		return null;
    	Map<Integer, Integer> hm = new HashMap<Integer,Integer>();
    	for (int i=0;i<inorder.length;++i)
    		hm.put(inorder[i], i);
    	return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, 
                              postorder.length-1,hm);
    }
    
    private TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                     Map<Integer,Integer> hm){
    	if (ps>pe || is>ie) return null;
    	TreeNode root = new TreeNode(postorder[pe]);
    	int ri = hm.get(postorder[pe]);
    	TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, ps+ri-is-1, hm);
    	TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, hm);
    	root.left = leftchild;
    	root.right = rightchild;
    	return root;
    }
    
    // method 3:
    // ref: https://discuss.leetcode.com/topic/3296/my-recursive-java-code-with-o-n-time-and-o-n-space/2
    // result: 2ms, beat 95.59%
    /*
    int pInorder;   // index of inorder array
    int pPostorder; // index of postorder array
    
    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
    if (pPostorder < 0) {
		return null;
	}
	
	// create root node
	TreeNode n = new TreeNode(postorder[pPostorder--]);
	
	// if right node exist, create right subtree
	if (inorder[pInorder] != n.val) {
		n.right = buildTree(inorder, postorder, n);
	}
	
	pInorder--;
	
	// if left node exist, create left subtree
	if ((end == null) || (inorder[pInorder] != end.val)) {
		n.left = buildTree(inorder, postorder, end);
	}
	
	    return n;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	pInorder = inorder.length - 1;
    	pPostorder = postorder.length - 1;
    	
    	return buildTree(inorder, postorder, null);
    }
    */
    
    /*
    // Idea: recursive (the last ele in postorder is the root, find the root in inorder, seperate inorder and post order 
    // to left and right, repeat the process) (used Arrays.copyOfRange)
    // result 20ms
    // things learned: Arrays.copyOfRange
    // 1) param from, is inclusive
    // 2) param to, is exclusive
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         
        if (inorder.length != postorder.length || 0 == inorder.length 
                || 0 == postorder.length) {
            return null;
        }
        
        return buildTreeHelper(inorder, postorder);
    }
    
    
    public TreeNode buildTreeHelper(int[] inorder, int[] postorder) {
    
        int range = postorder.length;
        int rootVal = postorder[range - 1];
       
        TreeNode root = new TreeNode(rootVal);
        
        int delimiter = 0;
        for (; delimiter < range; delimiter ++) {
            
            if (inorder[delimiter] == rootVal) {
                break;
            }
        } 
        
        // method 1
        if (delimiter > 0) {
            root.left = buildTreeHelper(Arrays.copyOfRange(inorder, 0, delimiter), 
                                        Arrays.copyOfRange(postorder, 0, delimiter));
        }
        
        if (delimiter + 1 < range) {
            root.right = buildTreeHelper(Arrays.copyOfRange(inorder, delimiter + 1, range), 
                                        Arrays.copyOfRange(postorder, delimiter, range - 1));
        }
        
        return root;
    }
    */
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*test case:
		 * []
			[]
			[1]
			[1]
			[4,1,3,6,2,7]
			[4,1,6,7,2,3]
			[5,4,3,2,1]
			[5,4,3,2,1]

		 * 
		 * 
		 */
	
	}

}
