
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class FractionToRecurringDecimal {
	
	public static String fractionToDecimal(int numerator, int denominator) {
        // * result : unsolved, used time 2 hours and half, % in the db, fastest in the db
        // *** things learned 1. I used the wrong condition to check, I used repeat value of num/deno to check repeat 
        // number which is wrong. I should use the repeat of num % deno to check repetition.
        // 2. margin of int.
        // 3. check negative : I used, numerator * denominator < 0, but it does not work for -1 and -2147483648
		// use (numerator < 0)^(denominator < 0) to check
        
        // problem:
        // *** 1) did not consider partial repeat 1/6 = 1(6) 
        // 2) did not consider 1 / 333 which means there is 0.(003), there are double zeros
        // *** use stringbuilder to build the result when cal, is far more better than use linkedhashmap to store result
        // I considered to user linkedhashmap, as I didn't consider example like 1/333 
        
        // special case: denominator == 0 || numerator == 0
        if (0 == denominator) {
            return "Denominator cannot be zero.";
        }
        
        if (0 == numerator) {
            return "0";
        }
        
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        StringBuilder intBuilder = new StringBuilder();
        StringBuilder fracBuilder = new StringBuilder();
        // index where repetition happens
        int index = 1;
        long intPart = 0;
        boolean hasRepeat = false;
        
        /* this one does not work for -1 and -2147483648
        if (numerator * denominator < 0) {
            intBuilder.append("-");
        }
        */
        
        boolean flag = (numerator < 0)^(denominator < 0);
        if (flag == true)
            intBuilder.append('-');
            
        long lNumerator = Math.abs((long)numerator);
        long lDenominator = Math.abs((long)denominator);
        
        intBuilder.append(lNumerator / lDenominator);
        lNumerator = lNumerator % lDenominator;
        
        if (lNumerator != 0) {
            
            fracBuilder.append(".");
           
            while (lNumerator != 0) {
                
                if (map.getOrDefault(lNumerator, 0) != 0) {
                    index = map.get(lNumerator);
                    hasRepeat = true;
                    break;
                }
                map.put((long)lNumerator, index);
                
                long digit = (lNumerator * 10) / lDenominator;
                lNumerator = (lNumerator * 10) % lDenominator;
                fracBuilder.append(digit);
                index ++;
            }
            
            if (true == hasRepeat) {
                fracBuilder.insert(index, "(").append(")");
            }
        }
        
        return intBuilder.append(fracBuilder).toString();
        
        // source: https://github.com/leetcoders/LeetCode-Java/commit/f6b2eead71b517cede699afd09ef15d93c1fe832
        // result: 3 ms
        /*
        if (numerator == 0) return new String("0");
        boolean flag = (numerator < 0)^(denominator < 0);
        long Numerator = Math.abs((long)numerator);
        long Denominator = Math.abs((long)denominator);
        StringBuffer res = new StringBuffer();
        if (flag == true) res.append('-');
        res.append(String.valueOf((Numerator / Denominator)));
        Numerator = Numerator % Denominator;
        if (Numerator == 0) return res.toString();
        res.append('.');
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        for (int i = res.length(); Numerator != 0; ++i) {
            if (map.get(Numerator) != null) break;
            map.put(Numerator, i);
            Numerator *= 10;
            res.append(String.valueOf((Numerator / Denominator)));
            Numerator %= Denominator;
        }
        
        if (Numerator == 0) return res.toString();
        res.insert(map.get(Numerator),"(");
        res.append(')');
        return res.toString();
        */
    }
    
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(fractionToDecimal(1, 7));
	}

}
