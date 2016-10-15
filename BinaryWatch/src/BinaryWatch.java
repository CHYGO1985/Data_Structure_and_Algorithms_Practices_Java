import java.util.ArrayList;
import java.util.List;


public class BinaryWatch {

	public static final int hTime[] = {1, 2, 4, 8};  
    public static final int mTime[] = {1, 2, 4, 8, 16, 32};  
      
    public static int calOne(int num) {  
        int ans = 0;  
        while(num != 0) {  
            ans += (num & 1);  
            num >>= 1;  
        }  
        return ans;  
    }  

    public static List<String> readBinaryWatch(int num) {
        // my idea: 1. brutal force to search the combination in H (8,4,2,1) and M (32,16,8,4,2,1), with the condition that
        // H < 12 and M < 60
        // 2. reverse way is to match H and M with num of LEDS, but it takes more time than 1, coz it must iterate through
        // many unuseful time.
        // method 2: implementation: http://blog.csdn.net/tc_to_top/article/details/52619938
        // 3. the same idea as method 2, but used bit to iterate through all the possibiliteis of H and M.
        
        List<String> ans = new ArrayList<>();  
        
        // * JJJ: 10 means 4 bits for hour + 6 bits for minutes. 100 0000 0000
        int all = 1 << 10;  
        for (int i = 0; i < all; i ++) {  
            
            // JJJ: all - 1: 10 bits of 1.
            // here, the idea is to iterate through all the possibility of 4 bits H and 6 bits M, when the count of 1 in 
            // the all - 1 matches the num, then check whether the H < 12 and M < 60
            if (calOne(i & (all - 1)) != num) {  
                continue;  
            }  
            // JJJ: get the value in H 00 0000 1111
            int h = (i & 15);  
            // JJJ: get the value in M 11 1111 0000
            int m = (i & 1008);  
            Integer hnum = new Integer(0);  
            Integer mnum = new Integer(0);  
            for (int j = 0; j < 4; j ++) {  
                if (((1 << j) & h) != 0) {  
                    hnum += hTime[j];  
                }  
            }  
            for (int j = 4; j < 11; j ++) {  
                if (((1 << j) & m) != 0) {  
                    mnum += mTime[j - 4];  
                }  
            }  
            if (mnum < 60 && hnum < 12) {  
                if (mnum < 10) {  
                    ans.add(hnum.toString() + ":0" + mnum.toString());  
                }  
                else {  
                    ans.add(hnum.toString() + ":" + mnum.toString());  
                }  
            }  
        }  
        return ans;  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
