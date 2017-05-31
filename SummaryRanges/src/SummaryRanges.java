import java.util.LinkedList;
import java.util.List;

/**
 * round 1: two pinters tech, 25 minutes, one pass, 1ms(62%) (32%, 0ms)
 * 30 minutes use anothe method, 0ms
 * special test case: 
 * 1) repeat num at the beginning or mid of a continuous nums
 * 2) seperate repeated nums
 * [0,0,1,1,1, 2,4,5,7,7,7,9,9,9] --> ["0","0->1","1","1->2","4->5","7","7","7","9","9","9"]
 * case 1: front = rear a
 * @author jingjiejiang
 * @history Jun 1, 2017
 */
public class SummaryRanges {

	// method 1: 1ms
	/*
	public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new LinkedList<>();
        // edge case: 
        if (null == nums || 0 == nums.length) return res;
        if (nums.length < 2) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        
        int front = 0;
        int rear = 1;
        int beginVal = nums[0];
        boolean isContin = false;
        while (rear < nums.length) {
            if (nums[front] + 1 == nums[rear]) {
                if (isContin == false) {
                    beginVal = nums[front];
                    isContin = true;
                }
            }
            else { // nums[front] == rear or, nums[rear] - nums[front] > 1
                // if there is more t
                if (isContin == true) {
                    isContin = false;
                    res.add(String.valueOf(beginVal) + "->" + String.valueOf(nums[front]));
                }
                else {
                    // 0,1,1,1,2 use rear only three 1
                    res.add(String.valueOf(nums[front]));
                }
            }
            
            front ++;
            rear ++;
        }
        
        if (isContin == true) res.add(String.valueOf(beginVal) + "->" + String.valueOf(nums[front]));
        else res.add(String.valueOf(nums[front]));
        
        return res;
    }
	*/
	
	// refactoring of method 1: without using boolean still 1ms
	/*
	public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new LinkedList<>();
        // edge case: 
        if (null == nums || 0 == nums.length) return res;
        if (nums.length < 2) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        
        int front = 0;
        int rear = 1;
        int beginVal = nums[0];
        while (rear < nums.length) {
            if (nums[front] + 1 == nums[rear]) {
                if (front == 0 || (front > 0 && nums[front] - 1 != nums[front - 1]) )
                    beginVal = nums[front];
            }
            else { // nums[front] == rear or, nums[rear] - nums[front] > 1
                // if there is more t
                if (front > 0 && nums[front] - 1 == nums[front - 1])
                    res.add(String.valueOf(beginVal) + "->" + String.valueOf(nums[front]));
                else
                    // 0,1,1,1,2 use rear only three 1
                    res.add(String.valueOf(nums[front]));
            }
            
            front ++;
            rear ++;
        }
        
        if (front > 0 && nums[front] - 1 == nums[front - 1]) 
            res.add(String.valueOf(beginVal) + "->" + String.valueOf(nums[front]));
        else res.add(String.valueOf(nums[front]));
        
        return res;
    }
    */
	
	// method 3: refactoring of methd 2, less than 20 lines, 0ms
	public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new LinkedList<>();
        // edge case: 
        if (null == nums || 0 == nums.length) return res;
        if (nums.length < 2) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        
        int front = 0;
        int rear = 1;
        // begin is used to keep the last available nums in the array
        String begin = String.valueOf(nums[front]);
        while (rear < nums.length) {
            if (nums[front] + 1 != nums[rear]) { // nums[front] == nums[rear] or, nums[rear] - nums[front] > 1
                if (front > 0 && nums[front] - 1 == nums[front - 1]) begin += "->" + String.valueOf(nums[front]);
                res.add(begin);
                // everytime add a string to result, update begin
                begin = String.valueOf(nums[rear]);
            }
            
            front ++;
            rear ++;
        }
        
        if (front > 0 && nums[front] - 1 == nums[front - 1]) begin += "->" + String.valueOf(nums[front]);
        res.add(begin);
        
        return res;
    }
	
	// method 4, refactoring of method 3 1ms (multiple if conditions), only one while loop (all if is in the while loop)
	/*
	public List<String> summaryRanges(int[] nums) {
        
        List<String> res = new LinkedList<>();
        // edge case: 
        if (null == nums || 0 == nums.length) return res;
        if (nums.length < 2) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        
        int front = 0;
        int rear = 1;
        String begin = String.valueOf(nums[front]);
        // use front as the condition instead of rear, is to avoid handle the left data when rear reach the end
        while (front < nums.length) {
            if (rear >= nums.length || nums[front] + 1 != nums[rear]) { // nums[front] == rear or, nums[rear] - nums[front] > 1
                // if there is more t
                if (front > 0 && nums[front] - 1 == nums[front - 1]) begin += "->" + String.valueOf(nums[front]);
                res.add(begin);
                if (rear < nums.length) begin = String.valueOf(nums[rear]);
            }
            
            front ++;
            rear ++;
        }
        
        return res;
	}
	*/	
}
