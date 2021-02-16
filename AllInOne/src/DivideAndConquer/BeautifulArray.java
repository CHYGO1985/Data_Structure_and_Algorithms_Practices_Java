import java.util.Map;

/**
 * 
 * 932. Beautiful Array
 * 
 * @author jingjiejiang
 * @history Feb 7, 2021
 * 
 */
class Solution {
    
    Map<Integer, int[]> memo;
    
    public int[] beautifulArray(int N) {
        memo = new HashMap();
        return builder(N);
    }

    public int[] builder(int N) {
        if (memo.containsKey(N))
            return memo.get(N);

        int[] ans = new int[N];
        if (N == 1) {
            ans[0] = 1;
        } else {
            int idx = 0;
            for (int num : builder((N + 1) / 2)) // odd nums
                ans[idx ++] = 2 * num - 1;
            for (int num : builder(N / 2)) // even nums
                ans[idx ++] = 2 * num;
        }

        memo.put(N, ans);
        
        return ans;
    }
}
