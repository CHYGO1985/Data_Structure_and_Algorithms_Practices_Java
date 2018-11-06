package PreviousQuestions;

/**
 * 
 * @author jingjiejiang Nov 6, 2018
 *
 */
public class Temp {
	
	public class Interval {
		int start;
		int end;
		Interval() { start = 0; end = 0; }
		Interval(int s, int e) { start = s; end = e; }
	}
	
	public static int candy(int[] ratings) {
        
		// for (0 --> ratigns.len - 1)
		//   if ([i] < [i] + 1) res[i + 1] += res[i] + 1 , sum += res[i + 1];
		//   else 
		//     start = i + 1
		//     while (i < len - 1 && [i] >= [i + 1]) i ++;
		//     end = [i]
		//     from end to start
		//       if ([j - 1] >= j) res[j - 1] = res[j] + 1 sum += res[j - 1]
		//     i --; // back to where it is
		// return res.length + sum
		int[] res = new int[ratings.length];
		
		for (int idx = 0; idx < ratings.length - 1; idx ++) {
			if (ratings[idx] < ratings[idx + 1]) {
				res[idx + 1] = res[idx] + 1;
			}
			else {
				int start = idx, revIdx = idx;
				while (revIdx < ratings.length - 1 && ratings[revIdx] >= ratings[revIdx + 1]) {
					revIdx ++;
				}
				int end = revIdx;
				while (end > start) {
					if (ratings[end - 1] > ratings[end] && res[end - 1] <= res[end]) {
						res[end - 1] = res[end] + 1;
					}
					end --;
				}
				idx = revIdx - 1; // 1 2 3 2 2 1 3 4, revIdx should at 1, so back to 2
			}
		}
		
        int sum = 0;
        for (int i : res) sum += i;
		return res.length + sum;
    }
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,2,2,1};
//		String s = "cbacdcbc";
		candy(arr);
	}
}
