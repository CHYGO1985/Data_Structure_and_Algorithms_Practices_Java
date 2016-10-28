import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class ShuffleAnArray {

	// method 1: 1) random shuffling --> reservoir sampling (length is know, so use nextInt(Length);
    // --> eleminate the ones that has already been chosen ( use a linkedlist to save index of original array)
    // 2) reset the array --> use an arraylist to keep the original index, then sort it. --> problem:what data strution 
    // to keep the relation between numbers and original index? (Map) --> TreeMap(Key is natual ordering) / 
    // two demensional array
    // *** result: 1) runtime: 298ms, beat 26.87%, fastest 208ms
    // 2) solve time: 60m. 
    // a. The turns that functions are called. I didn't think of reset can be called first.
    // b. I didn't think of when a ele in the array has been selected already.
    
    // method 2: 1) reset, use an array to copy nums.
    
	/*
    private int[] nums;
    private int[][] oriMap;
    private List<Integer> indexList;
    // this is to check whether reset is involed first
    private boolean isResetFst;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        oriMap = new int[nums.length][2];
        indexList = new LinkedList<Integer>();
        isResetFst = false;
    }

    
    //** Resets the array to its original configuration and return it. 
    public int[] reset() {
        
        // *** I did not think about the fact of invoke reset first
        if (false == isResetFst) {
            return nums;
        }
        else {
            int[] original = new int[nums.length];
            
            for (int i = 0; i < original.length; i ++) {
                original[i] = oriMap[i][1];
            }
            
            return original;
        }
    }
    
    //** Returns a random shuffling of the array. 
    public int[] shuffle() {
        
        int[] shuffled = new int[nums.length];
        Random ran = new Random();
        isResetFst = true;
        
        // init the index list
        for (int i = 0; i < nums.length; i ++) {
            indexList.add(i);
        }
        
        // one has already selected, sample size - 1.
        for (int size = nums.length, i = 0; size > 0; size --, i ++) {
            
            int rate = ran.nextInt(size);
            int index = indexList.get(rate);
            shuffled[i] = nums[index];
            indexList.remove(rate);
            
            // keep the original index in nums with elements
            oriMap[i][1] = nums[i];
        }
        
        return shuffled;
    }
    */
	
	/*
	// method 2: 1) reset, just nums to reset.
    // *** result: 258 -262ms, beat 66% - 60%
    
    private int[] nums;
    private List<Integer> indexList;
    // this is to check whether reset is involed first

    public Solution(int[] nums) {
        this.nums = nums;
        indexList = new LinkedList<Integer>();
    }

    
    //** Resets the array to its original configuration and return it.
    public int[] reset() {
        
        return nums;
    }
    
    // *** Returns a random shuffling of the array. 
    public int[] shuffle() {
        
        int[] shuffled = new int[nums.length];
        Random ran = new Random();
        
        // init the index list
        for (int i = 0; i < nums.length; i ++) {
            indexList.add(i);
        }
        
        // one has already selected, sample size - 1.
        for (int size = nums.length, i = 0; size > 0; size --, i ++) {
            
            int rate = ran.nextInt(size);
            int index = indexList.get(rate);
            shuffled[i] = nums[index];
            indexList.remove(rate);
        }
        
        return shuffled;
    }
    
    */
	
    // method 3:unsolved. shuffle --> use swap, so do the shuffle without extra spaces
    // http://www.cnblogs.com/grandyang/p/5875509.html
    // same idea as doing sorting in one array.
    // *** result: 253ms, beat 70%
    
    // method 4: unsolved
    // https://discuss.leetcode.com/topic/57088/simple-java-solution/2
    // *** result: 222ms, beat 98%
    
    private int[] nums;
    private int[] oriNums;
    // this is to check whether reset is involed first

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        // *** The use of clone() method to avoid the problem of pass by value.
    }

    
    // *** Resets the array to its original configuration and return it. 
    public int[] reset() {
        
        /*
        // *** I did not think about the fact of invoke reset first
        if (false == isResetFst) {
            return nums;
        }
        else {
            int[] original = new int[nums.length];
            
            for (int i = 0; i < original.length; i ++) {
                original[i] = oriMap[i][1];
            }
            
            return original;
        }
        */
        
        return nums;
    }
    
    // *** Returns a random shuffling of the array. 
    public int[] shuffle() {
        
        /*
        int[] copyNums = nums.clone();
        Random ran = new Random();
        
        // one has already selected, sample size - 1.
        for (int size = copyNums.length, i = 0; size > 0; size --, i ++) {
            
            int rate = ran.nextInt(size);
            swap(copyNums, rate, size - 1);
        }
        
        return copyNums;
        */
        
        int[] rand = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            int r = (int) (Math.random() * (i+1));
            rand[i] = rand[r];
            rand[r] = nums[i];
        }
        return rand;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int[] array = {1,2,3};
        ShuffleAnArray obj = new ShuffleAnArray(array);
        obj.shuffle();
        obj.reset();
        obj.shuffle();

	}

}
