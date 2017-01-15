import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Permutations {
	
	// idea: method 1: traditional DFS method with status arrays
    // result: 9ms, beat 20
	/*
    public List<List<Integer>> permute(int[] nums) {
       
       List<List<Integer>> list = new LinkedList<List<Integer>>();
       if (null == nums || 0 == nums.length) {
           return list;
       }
       
       boolean[] isValid = new boolean[nums.length];
       for (int i = 0; i < isValid.length; i ++) {
           isValid[i] = false;
       }
       
       permuteHelper(list, new LinkedList<Integer>(), nums, isValid);
       return list;
    }
    
    public void permuteHelper(List<List<Integer>> list, List<Integer> curList, int[] nums, boolean[] isValid) {
        
        if (curList.size() >= nums.length) {
            list.add(new LinkedList<Integer>(curList));
        }
        else {
            for (int i = 0; i < nums.length; i ++) {
                
                if (true == isValid[i]) {
                    continue ;
                }
                
                curList.add(nums[i]);
                isValid[i] = true;
                permuteHelper(list, curList, nums, isValid);
                curList.remove(curList.size() - 1);
                isValid[i] = false;
            }
        }
    }
    */
    
    // method 1.1: backtracking --> temp result list (save status array compared to method 1, but need more time to
    // check status as it is a linkedlist)
    // ref: https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets
    // -permutations-combination-sum-palindrome-partioning
    // result: 11 ms, beat 8.49%
    /*
    public List<List<Integer>> permute(int[] nums) {
       
       List<List<Integer>> list = new LinkedList<List<Integer>>();
       
       if (null == nums || 0 == nums.length) {
           return list;
       } 
       
       permuteHelper(list, new LinkedList<Integer>(), nums);
       return list;
    }
    
    public void permuteHelper(List<List<Integer>> list, List<Integer> curList, int[] nums) {
        
        if (curList.size() >= nums.length) {
            list.add(new LinkedList<Integer>(curList));
        }
        else {
            for (int i = 0; i < nums.length; i ++) {
                
                if (true == curList.contains(nums[i])) {
                    continue ;
                }
                
                curList.add(nums[i]);
                permuteHelper(list, curList, nums);
                curList.remove(curList.size() - 1);
            }
        }
    }
    */
    
    // method 2: (consider the permutation as swapping) recursive swap, O(1) extra space
    // idea ref: http://blog.csdn.net/xx77009833/article/details/17843415 
	public static List<List<Integer>> permute(int[] nums) {
	       
       List<List<Integer>> list = new LinkedList<List<Integer>>();
       if (null == nums || 0 == nums.length) {
           return list;
       }
       
       // permuteHelper(list, new LinkedList<Integer>(), nums, isValid);
       
       permuteSwapper(list, nums, 0);
       return list;
    }
    
    public static void permuteSwapper(List<List<Integer>> list, int[] nums, int front) {
        
        // the recursive process:
    	// start from 0, swap 0 -- 1, 2,..., nums.length
    	for (int rear = front + 1; rear < nums.length; rear ++) {
    		
    		int[] temp = nums.clone();
    		swap(temp, front, rear);
    		// add the new nums to list
    		list.add(convertArrayToList(temp));
    		
    		// within the swap, swap 1 --- 2, 3, ..., nums.length
    		permuteSwapper(list, nums, 0);
    	}
    	
    	// how the process will be ended
    	// when the front == nums.leng - 1 (which is the last element in the array)
    }
    
    public static void swap(int[] nums, int front, int rear) {
    	
    	int temp = nums[front];
    	nums[front] = nums[rear];
    	nums[rear] = temp;
    }

    public static List<Integer> convertArrayToList(int[] nums) {
    	
    	List<Integer> temp = new LinkedList<>();
    	
    	for(int i: nums) {
    		temp.add(i);
    	}
    	return temp;
    }

    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		
		List<List<Integer>> list = permute(nums);
		
		
	}

}
