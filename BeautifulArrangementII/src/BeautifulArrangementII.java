
/**
 * 
 * 667. Beautiful Arrangement II
 * 
 * round 1: solved, 45m, 3 attempts.
 * 
 * idea: draw some array, it can be found that
 * 1, 1 + k, 1 + 1, 1 + k - 1, 1 + 2 ... k + 2, k + 3.. n
 * 0    1      2       3         4
 * 
 * right = k, left = 1
 * we can tell that when index % 2 == 0, 1 + (right--)
 * else i + (left ++)
 * 
 * it is a two pointers tech
 * 
 * @author jingjiejiang
 * @history
 * 1. Oct 7, 2017
 */
public class BeautifulArrangementII {
	
	/*
	public int[] constructArray(int n, int k) {
        
        int[] res = new int[n];
        // the maximum different gaps are n - 1
        if (k == 0 || k > n - 1) return res;
        
        res[0] = 1;
        
        int left = 1;
        int right = k;

        int index = 1;
        while (left <= right) {
            if (index % 2 != 0) {
                res[index ++] = 1 + right;
                right --;
            }
            // index % 2 == 0
            else {
                res[index ++] = 1 + left;
                left ++;
            }
        }
        
        int count = n - res[1];
        // *** be careful about the conditions here
        while (count > 0) {
            res[index ++] = n - (count - 1);
            count --;
        }
        return res;
    }
	*/
	
	// optimised
	public int[] constructArray(int n, int k) {
        
        int[] res = new int[n];
        // the maximum different gaps are n - 1
        if (k == 0 || k > n - 1) return res;
        
        int left = 1;
        int right = k + 1;

        int index = 0;
        while (left <= right) {
            if (index % 2 != 0) res[index ++] = right --;
            // index % 2 == 0
            else res[index ++] = left ++;
        }
        
        int count = n - res[1];
        // *** be careful about the conditions here
        while (count > 0) {
            res[index ++] = n - (count - 1);
            count --;
        }
        return res;
    }

}
