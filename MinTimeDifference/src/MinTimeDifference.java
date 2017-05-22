import java.util.Arrays;
import java.util.List;


public class MinTimeDifference {
	
	/*
	// round 1: 3.5 hours, the solution sometimes generate TLE
    // method 2: change string that contains time to array
    // method 1: sorting + comparing one by one
	public int findMinDifference(List<String> timePoints) {
        // *** test case: ["10:32","14:55","13:03","15:52","15:05"]
        
        int min = 24 * 60;
        if (timePoints.size() == 0) return min;
        List<int[]> list = new LinkedList<int[]>();
        
        for (String s : timePoints) {
            String[] tmp = s.split(":");
            list.add(new int[]{Integer.valueOf(tmp[0]), Integer.valueOf(tmp[1])});
        }
        
        // change the time format to arr[h, m], sort the  new list
        
        Collections.sort(list, new Comparator<int[]>() {
            
            public int compare (int[] a, int b[]) {
                // for test case: [14:55","13:03","15:52","15:05"], if do not sort a[0] = b[0]
                // it may be the case that ["13:03", "14:55",15:52","15:05"], get wrong answer
                if (a[0] == b[0]) return a[1] - b[1];
                return a[0] - b[0];
            }
        });
        
        // compare the adjacent two points, do not change size
        // need to compare the first and last ele as well for case like ("00:00",...,"23:59")
        int size = list.size();
        if (size == 1) return min;
        for (int i = 0; i < size; i ++) {
            int[] fst = list.get(i);
            int[] scd = list.get((i + 1) % size);
            
            min = (fst[0] != scd[0]) ? Math.min(min, compareTime(fst, scd))
                : Math.min(min, Math.max(fst[1], scd[1]) - Math.min(fst[1], scd[1]));
        }
        
        return min;
    }
	    
    private int compareTime(int[] fst, int[] scd) {
        
        int difH1 = fst[0] - scd[0];
        int difM1 = fst[1] - scd[1];
        
        int difH2 = scd[0] - fst[0];
        int difM2 = scd[1] - fst[1];
        
//        int difH = fst[0] - scd[0];
//        int difM = fst[1] - scd[1];
//        if ( difH * difM > 0 ) {
//            if (difH > 0) min = Math.min(min, 60 * difH + difM);
//            else min = Math.min(min, 60 * (24 + difH) + difM);
//        }
//        else {
//            // difH > 0
//            if (difM < 0) min = Math.min(min, 60 * difH + difM);
//            // difM > 0 means difH < 0
//            else min = Math.min(min, 60 * (24 + difH) + difM);
//        }
        
        // refactoring of the above logic
        if (difH1 > 0) return Math.min( difH1 * 60 + difM1, 60 * (24 + difH2) + difM2);
        return Math.min( difH2 * 60 + difM2, 60 * (24 + difH1) + difM1);
    }
	*/
    
	// method 2: array-hash method, change time from hour:minutes to minutes array (24*60)
    // ref: https://discuss.leetcode.com/topic/82573/verbose-java-solution-bucket/2
	public static int findMinDifference(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            // if there is two same time stamp, return 0
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        // the smallest and biggest value in the array for case [00:00, ... , 23:59]
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    // i - prev is the time difference
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        
        min = Math.min(min, (24 * 60 - last + first));
        
        return min;
    }
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList(new String[]{"10:32","14:55","13:03","15:52","15:05"});
		findMinDifference(list);
	}

}
