/**
 * round 1: unsolved
 * 
 * method 1: based on the sumption that the capacity is decided by the shortest part.
 * ref: https://discuss.leetcode.com/topic/3016/share-my-short-solution
 * 
 * @author jingjiejiang
 * @history Jun 18, 2017
 */ 
public class TrappingRainWater {

	public static int trap(int[] A){
	    int a = 0;
	    int b = A.length - 1;
	    int max = 0;
	    int leftmax = 0;
	    int rightmax = 0;
	    while(a <= b){
	        leftmax = Math.max(leftmax, A[a]);
	        rightmax = Math.max(rightmax, A[b]);
	        if(leftmax < rightmax){
	            max += (leftmax - A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
	            a ++;
	        }
	        else{
	            max += (rightmax - A[b]);
	            b --;
	        }
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		// trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
		trap(new int[]{0,1,0,2,1,0,1});
	}

}
