/**
 * 
 * 670. Maximum Swap
 * 
 * round 1: solved, 1 hours, 2 attempts
 * 
 * idea: two pointers tech (from different ends)
 * it is very easy to related to two pointers tech, if consider a test case:
 *  9 8 7 6 5 9, in this case, we should swap 9 '8' 7 6 5 '9'
 *  
 * test case ***
 * 1. 115
 * 2. 9 8 7 6 5 9
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 7, 2017
 */
public class MaximumSwap {
	
	public int maximumSwap(int num) {
        
        if (num <= 11) return num;
        
        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        int swapPos = left;
        
        // locate the pos that max < current num, 98'5'6
        while (left < arr.length){
        
            if (arr[swapPos] < arr[left]) break;
            swapPos = left;
            left ++;
        }
        
        if (left >= arr.length) return num;
        
        int max = arr[right];
        int maxPos = right;
        
        // from left to right, find the max val
        while ( -- right > swapPos) {
            if (arr[right] > max) {
                max = arr[right];
                maxPos = right;
            }
        }
        
        // find the pos that should swap 98759 -->(find 8)
        left = swapPos;
        while (left >= 0) {
            if (max > arr[left]) left --;
            else break;
        }
        
        // compensate for --
        left ++;
        
        char tmp = arr[maxPos];
        arr[maxPos] = arr[left];
        arr[left] = tmp;
        
        return Integer.valueOf(String.valueOf(arr)); 
    }

}
