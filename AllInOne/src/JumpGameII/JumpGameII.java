package JumpGameII;

import java.util.Arrays;

// dfs
// 2 3 1 1 4
// 0 1 2 2 2

// 2 0 1 1 4
// 0 1 1 2 3

// 1 2 0 1 2
public class JumpGameII {
	
//	public static int jump(int[] nums) {
//		
//		int[] steps = new int[nums.length];
//		Arrays.fill(steps, Integer.MAX_VALUE);
//		steps[0] = 0;
//		
//		for (int index = 0; index < nums.length; index ++) {
//			for (int count = 1; count <= nums[index]; count ++) {
//				if (index + count < nums.length) {
//					int temp = steps[index] + 1;
//					steps[index + count] = Math.min(temp, steps[index + count]);
//					if (index + count == nums.length) {
//						return steps[index + count];
//					}
//				}
//			}
//		}
//		return steps[nums.length - 1];
//    }
	
	public static int jump(int[] A) {
		int jumps = 0, curEnd = 0, curFarthest = 0;
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}

}
