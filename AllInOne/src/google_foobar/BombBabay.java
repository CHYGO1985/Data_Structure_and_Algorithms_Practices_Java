import java.math.BigInteger;

/**
 * 
 * @author jingjiejiang
 * @history Mar 29, 2021
 * 
 */
public class BombBaby {

    public static final String IMPO_RES = "impossible";
    public static final BigInteger MACH_TAR = BigInteger.ONE;
    public static final BigInteger FAC_TAR = BigInteger.ONE;

    // public static String solution(String x, String y) {
    //     // Your code here

    //     if (x.equals(y)) return IMPO_RES;
        
    //     BigInteger machNum = new BigInteger(x);
    //     BigInteger faculaNum = new BigInteger(y);
        
    //     if (machNum.compareTo(new BigInteger("0")) <= 0 
    //         || faculaNum.compareTo(new BigInteger("0")) <= 0) {
    //             return IMPO_RES;
    //         }
        
    //     BigInteger steps = BigInteger.ZERO;

    //     while (machNum.compareTo(MACH_TAR) != 0 
    //         || faculaNum.compareTo(FAC_TAR) != 0) {

    //         int compRes = machNum.compareTo(faculaNum);

    //         if (compRes == 0) {
    //             return IMPO_RES;
    //         } else if (compRes == 1) {
    //             machNum = machNum.subtract(faculaNum);
    //         } else {
    //             faculaNum = faculaNum.subtract(machNum);
    //         }
            
    //         steps = steps.add(BigInteger.ONE);
    //     }

    //     return String.valueOf(steps);
    // }

    public static String solution(String x, String y) {
        // Your code here

        if (x.equals(y)) return IMPO_RES;
        BigInteger machNum = new BigInteger(x);
        BigInteger faculaNum = new BigInteger(y);
        BigInteger steps = BigInteger.ZERO;

        while (machNum.compareTo(MACH_TAR) != 0 
            || faculaNum.compareTo(FAC_TAR) != 0) {

                if (machNum.compareTo(BigInteger.ZERO) <= 0 
            || faculaNum.compareTo(BigInteger.ZERO) <= 0) {
                return IMPO_RES;
            }

            int compRes = machNum.compareTo(faculaNum); 

            BigInteger bigNum = machNum.compareTo(faculaNum) == 1 ? machNum : faculaNum;
            BigInteger smallNum = machNum.compareTo(faculaNum) == 1 ? faculaNum : machNum;

            BigInteger divisions = bigNum.divide(smallNum);
            BigInteger remainder = bigNum.remainder(smallNum);

            if (remainder.equals(BigInteger.ZERO)) {
                // 11: 1 should be 10 steps
                divisions = divisions.subtract(BigInteger.ONE);
            }

            if (divisions.compareTo(BigInteger.TEN) >= 0) {

                switch(compRes) {
                    case 0:
                        return IMPO_RES;
                    case 1: 
                        machNum = machNum.subtract(faculaNum.multiply(divisions));
                        machNum = remainder.equals(BigInteger.ZERO) ? faculaNum : machNum;
                        break;
                    case -1:
                        faculaNum = faculaNum.subtract(machNum.multiply(divisions));
                        faculaNum = remainder.equals(BigInteger.ZERO) ? machNum : faculaNum;
                        break;
                    default:
                        return IMPO_RES;
                }    

                steps = steps.add(divisions);
            } else {

                switch (compRes) {
                    case 0: 
                        return IMPO_RES;
                    case 1: 
                        machNum = machNum.subtract(faculaNum);
                        break;
                    case -1: 
                        faculaNum = faculaNum.subtract(machNum);
                        break;
                    default:
                        return IMPO_RES;
                }

                steps = steps.add(BigInteger.ONE);
            }
        }

        return String.valueOf(steps);
    }

    public static void main(String[] args) {
        
        String Mach = "11";
        String Facula = "1";
        
        // String res = solution(Mach, Facula);

        System.out.println(solution(Mach, Facula));
        // System.out.println("hi");
    }
}