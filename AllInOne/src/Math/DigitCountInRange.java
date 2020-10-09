/**
 * 
 * 1067. Digit Count in Range
 * 
 * @CHYGO1985
 * @history Oct 9, 2020
 * 
 */
public class DigitCountInRange {
    // public int digitsCount(int d, int low, int high) {
    //     return countDigit(high, d) - countDigit(low-1, d);
    // }
    
    // int countDigit(int n, int d) {
    //     if(n < 0 || n < d) {
    //         return 0;
    //     }
        
    //     int count = 0;
    //     for(long i = 1; i <= n; i*= 10) {
    //         long divider = i * 10;
    //         count += (n / divider) * i;
            
    //         if (d > 0) {
    //             count += Math.min(Math.max(n % divider - d * i + 1, 0), i); // comment1: tailing number need to be large than d *  i to qualify.
    //         } else {
    //             if(n / divider > 0) {
                    
    //                 if(i > 1) {  // comment2: when d == 0, we need avoid to take numbers like 0xxxx into account.
    //                     // - i is because for example, 100's zero, 1000 /1000 * 100 = 100, but actually, is 0, so we minus one base which is - i
    //                     count -= i;
    //                     // min, is becase, e.g. 107, 10's zero,  107 % 10 + 1 = 8 10's zero, min(8, 10) get 8 e.g. 121, 121 % 10
    //                     count += Math.min(n % divider + 1, i);  
    //                 }
    //             }
    //         }
    //     }
        
    //     return count;
    // }

    public int digitsCount(int d, int low, int high) {

        // if (d < 0 || low < 0 || high < 0) return 0;

        return getCount(d, high) - getCount(d, low - 1);
    }

    private int getCount(int d, int num) {

        int count = 0;

        for (long base = 1; base <= num; base *= 10) {

            long dividend = base * 10;
            count += (num / dividend) * base;

            if (d > 0) {
                // need to + 1: num = 131, d = 3, 10' 3, 130 and 131
                count += Math.min((Math.max((num % dividend) - d * base + 1 , 0)), base);
            } else {
                // 9 / 10 = 0
                if (num / dividend > 0) {
                    // i = 1, num / dividend * base can get the res directly
                    if (base > 1) {
                        // for 100's zero, 1000 / 1000 * 100 = 100,  but actually, there is only one
                        // - i is because for example, 100's zero, 1000 /1000 * 100 = 100, but actually, is 0, so we minus one base which is - i
                        count -= base;
                        // min, is becase, e.g. 107, 10's zero,  107 % 10 + 1 = 8 10's zero, min(8, 10) get 8 
                        // e.g. 121, 121 % 10 = 21, should get 10
                        count += Math.min(num % dividend + 1, base);
                    }
                }
            }
        }

        return count;
    }
}
