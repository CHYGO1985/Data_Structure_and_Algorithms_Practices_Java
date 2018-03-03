package FourSumii;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 454. 4Sum II
 * round 1: solved, 2 hours
 * 
 * @author jingjiejiang
 * @history
 * 1. Created on Mar 4, 2018
 */
public class FourSumII {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j ++) {
                
                int tmp = map.getOrDefault((C[i] + D[j]), 0);
                tmp += 1;
                map.put((C[i] + D[j]), tmp);
            }
        }
        
        
        for (int i = 0; i < A.length; i ++) {
            
            for (int j = 0; j < B.length; j ++) {
                
                int val = 0 - A[i] - B[j];
                
                int tmp = map.getOrDefault(val, 0);
                res += tmp;
            }
        }
        
        return res;
    }

}
