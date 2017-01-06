import java.util.LinkedList;
import java.util.List;

public class TemplateCode {
	
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
