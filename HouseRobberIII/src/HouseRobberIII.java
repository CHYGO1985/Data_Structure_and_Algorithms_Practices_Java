
public class HouseRobberIII {
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
        TreeNode(int x) { val = x; }
	}
	
	public static int rob(TreeNode root) {
        // *** unsolved, solution from: http://blog.csdn.net/happyaaaaaaaaaaa/article/details/50880121
        // * idea: level traverse. use odd or even number to get two sums, then get the maximum.
        // * result : unsolved, 1ms, beat 78.64%, fastest in the database,  used 2 hours to think, 2 hours to learn
        // * things learned: 
        // 1) the example given is to inlight my thought, not confine my thought, do not consider 
        // the example as the only case for the quesion.
        // 2) dynamic programming: find the atomic step first
        // 3) use [0,1] to control interval
        
        /*
        // ****I misunserstand the quesion, the combination can be level 1 + level 4, not only level 1 + 3 + 5... 
        // and it can be at different level, my thinking was confined by the example. 
        
        // special case:
        // *** I did not consider the case of only one root
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int indicator = 1; // level indicator
        int sumEven = 0;
        int sumOdd = 0;
        int levelSum = 0; // sum of one level
        int preSize = 0;
        
        if (root != null) {
            queue.add(root);
            preSize = 1;
        }
        else {
            return 0;
        }
        
        while (false == queue.isEmpty()) {
            
            if (0 == preSize) {
            
                // else if indicator = 0, assign preSize = queque.size, new indicator = 0
                // if indicator (for pre level) = even (0 , 2, ...),  means next level is odd, add levelsum to sumOdd
                // else,  add previous sum to sumEven
                preSize = queue.size();
                if (indicator % 2 != 0) {
                    sumEven += levelSum;
                }
                else {
                    sumOdd += levelSum;
                }
                
                levelSum = 0;
                indicator ++;
            }
            
            // for replacing presize and cursize, the node should be polled out here.
            TreeNode curNode = queue.poll();
            preSize --;
            
            // if cur.left != null, add cur.left to queue, add the node value to current sum
            if (curNode.left != null) {
                queue.add(curNode.left);
                levelSum += curNode.left.val;
            }
            
            // if cur.right != null, add cur.right to queuqe,
            if (curNode.right != null) {
                queue.add(curNode.right);
                levelSum += curNode.right.val;
            }
        }
        
        
        return sumEven >= (sumOdd + root.val)? sumEven : (sumOdd + root.val); 
        */
        
        return dfs(root)[1]; 
    }
    
    private static int[] dfs(TreeNode root) {  
        int[] rob ={0, 0};  
        if(root != null) {  
            int[] robLeft = dfs(root.left);  
            int[] robRight = dfs(root.right);  
            
            // ****use [0,1] to control the interval is a tech that I didnot know before
            // it is the same whether use 0 to represent the max or 1.
            /*
            rob[1] = robLeft[0] + robRight[0];  
            rob[0] = Math.max(rob[1], robLeft[1] + robRight[1] + root.val);  
            */
            
            // why use 0 and 1 like this, not in an opsite way  
            rob[0] = robLeft[1] + robRight[1];  
            rob[1] = Math.max(robLeft[0] + robRight[0] + root.val, rob[0]);  
        }  
        return rob;  
    }  

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
