import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 299. Bulls and Cows
 * 
 * ref: https://leetcode.com/problems/bulls-and-cows/discuss/74621/One-pass-Java-solution
 * 
 * @author jingjiejiang
 * @history Sep 10, 2020
 * 
 */
public class Solution {
    public String getHint(String secret, String guess) {

        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];

        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0'] ++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0'] -- > 0) cows++;
            }
        }

        return bulls + "A" + cows + "B";
    }
}
