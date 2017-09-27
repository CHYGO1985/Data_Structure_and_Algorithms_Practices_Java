
/**
 * 
 * 277. Find the Celebrity
 * 
 * round 1: solved, 1hr, two pointers tech, 2 attempts
 * 
 * idea: from brutal force to two pointers tech
 * 1. first, think about brutal force method, which needs to iterate
 * n, get one X at a time, check all n - 1 (y, X) and k(X, y)
 * 
 * 2. we can use two pointers tech to locate the potential candidate
 * the essential part is if K(A,B) = true and K(B,A) = false, we can
 * definitely say that A is not a candidate, and B may be a candidate
 * so we use B to compare with next ele.
 * 
 * then iterate through the loop to verify that
 * 
 * *** test case: 0, 1, 2
 * if k(0,2) & k(2,0) both true or false, we do not skip both, 
 * coz k(0,2) , k(2,0) are both true, only guarantee that 2 is not a
 * candidate, but 0 may be, so we only skip 2 
 * 
 * --> from the analysis we can use only one condition is A know B
 * then A definitely is not a candidate
 * 
 * @author jingjiejiang
 * @history
 * 1. Sep 27, 2017
 */
public class FindTheCelebrity {
	
	boolean knows(int a, int b){
		return (a > b);
	}
	
	public int findCelebrity(int n) {
        
        if (n == 0) return -1;
        if (n == 1) return 0;
        
        int res = -1;
        int head = 0, rear = n - 1;
        while (head < rear) {
      
        	/*
            boolean test_1 = knows(head, rear);
            boolean test_2 = knows(rear, head);
            if (test_1 == true && test_2 == false) {
                head ++;
                res = rear;
            }
            else {
                rear --;
                res = head;
            }
            */
            
            boolean test_1 = knows(head, rear);
            
            if (test_1 == true) {
                head ++;
                res = rear;
            }
            else {
                rear --;
                res = head;
            }
        }
        
        // *** verify if everybody know cel and cel knows nobody
        if (res == -1) return res;
        else {
            for (int i = 0; i < n; i ++) {
                if (i != res) {
                    if (knows (i, res) == false || knows(res, i) == true) 
                        return -1;
                }
            }
        }
        
        return res;
    }

}
