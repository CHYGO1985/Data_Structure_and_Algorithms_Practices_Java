/**
 * 
 * 12. Integer to Roman
 * 
 * @author jingjiejiang
 * @history Feb 20, 2021
 * 
 */
class Solution {
    
    private int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};    
    private String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public String intToRoman(int num) {
        
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int idx = 0; idx < values.length && num >= 0; idx ++) {
            while (values[idx] <= num) {

                num -= values[idx];
                sb.append(symbols[idx]);
            }
        }

        return sb.toString();
    }
}