import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * 1058. Minimize Rounding Error to Meet Target
 * 
 * @author jingjiejiang
 * @history Jan 4, 2021
 * 
 */
class Solution {
    public String minimizeError(String[] prices, int target) {
        
        assert prices != null && prices.length >= 1 && target >= 0;

        Queue<Double> difPriQue = new PriorityQueue<>();
        float res = 0.0f;

        for (String price : prices) {

            float curPrice = Float.valueOf(price);
            double low = Math.floor(curPrice);
            double high = Math.ceil(curPrice);

            if (low != high) {
                difPriQue.offer((high - curPrice) - (curPrice - low));
            }

            res += curPrice - low;
            target -= low;
        }

        if (target < 0 || target > difPriQue.size()) return "-1";

        while (target -- > 0) {
            res += difPriQue.poll();
        }

        return String.format("%.3f", res);
    }
}