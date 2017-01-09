import java.util.LinkedList;
import java.util.List;


public class Permutations {
	
	public static List<List<Integer>> permute(int[] nums) {
       
       List<List<Integer>> list = new LinkedList<List<Integer>>();
       
       if (null == nums || 0 == nums.length) {
           return list;
       } 
       
       permuteHelper(list, new LinkedList<Integer>(), nums);
       return list;
    }
    
    public static void permuteHelper(List<List<Integer>> list, List<Integer> curList, int[] nums) {
        
        if (nums.length >= curList.size()) {
            list.add(new LinkedList<Integer>(curList));
        }
        else {
            for (int i = 0; i < nums.length; i ++) {
                
                if (true == list.contains(nums[i])) {
                    continue ;
                }
                
                curList.add(nums[i]);
                permuteHelper(list, curList, nums);
                curList.remove(curList.size() - 1);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		List<List<Integer>> list = permute(nums);
	}

}
