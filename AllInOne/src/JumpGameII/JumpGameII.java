package JumpGameII;

// dfs
// 2 3 1 1 4
// 0 1 2 2 2

// 2 0 1 1 4
// 0 1 1 2 3

// 1 2 0 1 2
/**
 * 
 * @author jingjiejiang created on Aug 25, 2017
 *
 */
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
		// why A should be less than length - 1 ? because it is to check to jump to last position
		for (int i = 0; i < A.length - 1; i++) {
			curFarthest = Math.max(curFarthest, i + A[i]);
			// if i reaches the current end, give it a jump, and curEnd = curFarthest (the fast pos that can be jump in current round
			// from curBegin to curEnd)
			if (i == curEnd) {
				jumps++;
				curEnd = curFarthest;
			}
		}
		return jumps;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}

}
