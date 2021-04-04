/**
 * 
 * 50. Pow(x, n)
 * 
 * @author jingjiejiang
 * @history Apr 4, 2021
 * 
 */
class Solution {
    public double myPow(double x, int n) {

        assert x > -100.0 && x < 100.0;

        if (n == 0) return 1.0;
        
        double res = getHalfPow(x, n < 0 ? -n : n);

        return n < 0 ? 1 / res : res;
    }

    private double getHalfPow(double base, int factor) {

        if (factor == 0) return 1.0;

        double res = getHalfPow(base, factor / 2);

        if (factor % 2 == 0) {
            return res * res;
        } else {
            return res * res * base;
        }       
    }
}