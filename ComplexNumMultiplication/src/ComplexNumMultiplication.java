
public class ComplexNumMultiplication {

	public String complexNumberMultiply(String a, String b) {
        // round 1: 40 ms, 5ms, beat 96%
        // idea: straight forward, interpret each string one by one
        
        // method 2: use Stream, 3 lines
        // ref: https://discuss.leetcode.com/topic/84261/java-3-liner/2
        /*
        public String complexNumberMultiply(String a, String b) {
            int[] coefs1 = Stream.of(a.split("\\+|i")).mapToInt(Integer::parseInt).toArray(), 
                  coefs2 = Stream.of(b.split("\\+|i")).mapToInt(Integer::parseInt).toArray();
            return (coefs1[0]*coefs2[0] - coefs1[1]*coefs2[1]) + "+" + (coefs1[0]*coefs2[1] + coefs1[1]*coefs2[0]) + "i";
        }
        */
        
        String res = "";
        if (a == null || a.length() < 4 || b == null || b.length() < 4) return res;
        // [0] : first num, [1]: calculator [2]: second num
        int[] resA = new int[3];
        int[] resB = new int[3];
        
        findElem(a, resA);
        findElem(b, resB);
        
        res = "" + ( (resA[0] * resB[0]) + (resA[1] * resB[1]) * (resA[2] * resB[2]) * (-1) );
        res += "+" + (resA[2] * resB[0] + resB[2] * resA[0]) + "i";
        
        return res;
    }
    
    private void findElem(String a, int[] res) {
        
        // initialise with default value
        for (int i = 0; i < res.length; i ++) res[i] = 1;
        
        String tmp = "";
        int i = 0;
        if (a.charAt(i) == '-') {
            res[0] = -1;
            i ++;
        }
        // *** coz it has "i", so it is better to use '0' and '9
        // *** should use >= here, be careful
        while (a.charAt(i) >= '0' && a.charAt(i) <= '9') tmp += a.charAt(i ++);
        res[0] = res[0] * Integer.valueOf(tmp);
        res[1] = a.charAt(i ++) == '-' ? -1 : 1;
        if (a.charAt(i) == '-') {
            res[2] = -1;
            i ++;
        }
        
        tmp = "";
        while (a.charAt(i) >= '0' && a.charAt(i) <= '9') tmp += a.charAt(i ++);
        // *** for the case that 1 + i, there is not any num before "i"
        if (tmp == "") tmp = "1";
        res[2] = res[2] * Integer.valueOf(tmp);
    }
}
