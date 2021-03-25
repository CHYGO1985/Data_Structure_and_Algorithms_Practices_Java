import java.util.List;

public class tmp {
    // get depth of BST
    // root : depth = 1

    static int maxDepth = 0;
    
    public int getDepth(TreeNode root) {
        
        getDepthHelper(root, maxDepth);
        
        return maxDepth;
    }

    // 0: max depth
    private void getDepthHelper(TreeNode root, int curDepth,  List<Integer> curDepthList, List<Integer> maxDepthVals) {

        if (root == null) return ;

        // current depth + 1;
        curDepth += 1;
        // update max depth
        // maxDepth[0] = Math.max(curDepth, maxDepth[0]);

        curDepthList.add (root.val);

        if (curDepth > maxDepth) {
            maxDepth = curDepth;
            // maxDepthVals.add(root.val);
            maxDepthVals = new ArrayList<>(curDepthList);
        }

        // if (maxDepth[0] == maxDepthVals.size()) {
        //     maxDepthVals.remove(maxDepthVals.size() - 1);
        // }

        // if (curDepth >= maxDepth[0]) {
        //     maxDepth[0] = curDepth;
        //     maxDepthVals.add(root.val);
        // }

        getDepthHelper(root.left, curDepth, maxDepthVals); 
        if(curDepth < maxDepth) curDepthList.remove(curDepthList.size() - 1);
        //
        getDepthHelper(root.right, curDepth, maxDepthVals);
    }
}

// root 2
// left: root.left 3
// right: root.right 3

Class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
}