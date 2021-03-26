import java.util.Arrays;

public class Solution1 {
    public static String[] solution(String[] l) {
        // Your code here
        int[][] verNums = new int[l.length][3];

        for (int idx = 0; idx < l.length; idx ++) {

            String[] verNum = l[idx].split("\\.");

            for (int pos = 0; pos < verNums[0].length; pos ++) {
                // as 2.0 goes before 2.0.0
                verNums[idx][pos] = (pos >= verNum.length ? -1 : Integer.valueOf(verNum[pos]));
            }
        }

        Arrays.sort(verNums, (a, b) -> 
            
            a[0] != b[0] ? a[0] - b[0] : (a[1] != b[1] ? a[1] - b[1] : a[2] - b[2])
        );

        String[] res = new String[l.length];

        for (int idx = 0; idx < res.length; idx ++) {
            StringBuilder builder = new StringBuilder();
            for (int pos = 0; pos < verNums[idx].length; pos ++) {
                if (verNums[idx][pos] == -1) {
                    break;
                }
                builder.append(verNums[idx][pos] + ".");
            }

            res[idx] = builder.subSequence(0, builder.length() - 1).toString();
        }

        return res;
    }
}