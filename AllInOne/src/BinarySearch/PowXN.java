/**
 * 
 * 50. Pow(x, n)
 * 
 * @author jingjiejiang
 * @history Apr 16, 2021
 * 
 */
public class PowXN {
    public double myPow(double x, int n) {

        assert x > -100 && x < 100;

        if (n == 0) return 1.0;

        double res = getPow(x, n < 0 ? -n : n); 

        return n < 0 ?  1 / res : res;
    }

    private double getPow(double base, int factor) {

        if (factor == 0) return 1.0;

        doubel res = getPow(base, factor / 2);

        if (factor % 2 == 0) {
            return res * res;
        } else {
            return res * res * base;
        }
    }
}
