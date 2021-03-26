public class Lucky_Lamb {
    public static int solution(int total_lambs) {
        //Your code here

        assert total_lambs >= 1;

        int[] lambArray = new int[3];
        int curLambSum = 1;
        int minHenchman = 1;
        int maxHenchMan = 1;

        lambArray[0] = 0; lambArray[1] = 1;

        // generous solution, get min henchman: [i] = [i - 1] * 2
        while (total_lambs > curLambSum) {

            lambArray[2] = lambArray[1] * 2;
            if (curLambSum + lambArray[2] > total_lambs) break;

            minHenchman += 1;
            curLambSum += lambArray[2];
            lambArray[1] = lambArray[2];
        }

        curLambSum = 1;
        lambArray[0] = 0; lambArray[1] = 1;
        
        // stindy stolution, get max henchman : [i] = [i - 1] + [i - 2]
        while (total_lambs > curLambSum) {

            lambArray[2] = lambArray[0] + lambArray[1];
            if (curLambSum + lambArray[2] > total_lambs) break;

            maxHenchMan += 1;
            curLambSum += lambArray[2];
            lambArray[0] = lambArray[1];
            lambArray[1] = lambArray[2];
        }

        return maxHenchMan - minHenchman;
    }
}
