import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class StrobogrammaticNumber {
	
	public boolean isStrobogrammatic(String num) {
        // idea: if find 2,3,4,5,7, then definitely is not a Strobogrammatic
        // for 6 and 9, they must be 
        // two pointers technique
        // if 8, front = end; if 1, front = end; if 6 then end must be 9; if 9, then front must be 6
        // *** how to initialise a set in java
        // round 1: 30 minutes, 1ms
        
        // method 2: https://discuss.leetcode.com/topic/20837/4-lines-in-java/2 
        /*
        public boolean isStrobogrammatic(String num) {
        for (int i=0, j=num.length()-1; i <= j; i++, j--)
            if (!"00 11 88 696".contains(num.charAt(i) + "" + num.charAt(j)))
                return false;
        }
        */
        char[] arr = num.toCharArray();
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(0, 1, 6, 8, 9));
        int front = 0;
        int end = arr.length - 1;
        
        while (front <= end) {
            if (set.contains(arr[front] - '0') == false || set.contains(arr[end] - '0') == false) {
                return false;
            }
            else {
                if (arr[front] - '0' == 6) {
                    if (arr[end] - '0' != 9)
                        return false;
                }
                else if (arr[front] - '0' == 9) {
                    if (arr[end] - '0' != 6)
                        return false;
                }
                else if (arr[front] != arr[end]) {
                    return false;
                }
                front ++;
                end --;
            }
        }
        
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
