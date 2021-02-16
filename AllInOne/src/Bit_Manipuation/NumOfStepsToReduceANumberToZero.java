/**
 * 
 * 1342. Number of Steps to Reduce a Number to Zero
 *
 * @author jingjiejiang
 * @history FEb 12, 2021
 * 
 */
class Solution {
    public int numberOfSteps1(int num) {
        
        assert num >= 0 && num <= 1e6;

        String binaryNum = Integer.toBinaryString(num);
        int step = 0;

        for (char bit : binaryNum.toCharArray()) {

            if (bit == '1') {
                step += 2;
            } else {
                step += 1;
            }
        }

        return step - 1;
    }

    public int numberOfSteps2(int num) {
        
        assert num >= 0 && num <= 1e6;

        if (num == 0) return 0;

        int steps = 0;

        for (int powOfTwo = 1; powOfTwo <= num; powOfTwo = powOfTwo << 1) {
            if ((powOfTwo & num) != 0) {
                steps += 2;
            } else {
                steps += 1;
            }
        }

        return steps - 1;
    }
}
