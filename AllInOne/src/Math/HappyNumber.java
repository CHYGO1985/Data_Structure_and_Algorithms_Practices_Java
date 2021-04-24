import java.util.HashSet;

/**
 * 
 * 202. Happy Number
 * 
 * @author jingjiejiang
 * @history Apr 7, 2021
 * 
 */
public class HappyNumber {

    private int getNext(int num) {

        int sum = 0;

        while (num > 0) {

            int curDigit = num % 10;
            num = num / 10;
            sum += curDigit * curDigit;
        }

        return sum;
    }

    // cycle detext via using Set (TLE)
    public boolean isHappy1(int n) {
        
        assert n >= 1;

        Set<Integer> numSet = new HashSet<>();

        while (n != 1 || !numSet.contains(n)) {

            numSet.add(n);
            n = getNext(n);
        }
        
        return n == 1;
    }  

    public boolean isHappy2(int n) {
        
        assert n >= 1;

        int slow = n;
        // step go one step forward to avoid condition fast != slow
        int fast = getNext(n);

        while (fast != 1 && fast != slow) {

            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;
    }  
}
