package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 * @author jingjiejiang Feb 3, 2019
 *
 */
public class ReorderLogFiles {
//	public String[] reorderLogFiles(String[] logs) {
//        // distinguish letter and digit
//		// sort letters
//		List<String> list = new ArrayList<>();
//		
//		// store letters log in a sep list
//		List<String> letterList = new LinkedList<>();
//		
//		for (String log : logs) {
//			String[] tmp = log.split(" ");
//			if (tmp[1].matches("\\d+")) {
//				list.add(log);
//			} else {
//				letterList.add(log);
//			}
//		}
//        
//		Collections.sort(letterList, (str1, str2) -> {
//			str1 = str1.substring(str1.indexOf(" ") + 1);
//			str2 = str2.substring(str2.indexOf(" ") + 1);
//			return str1.compareTo(str2);
//		});
//		
//		for (int idx = letterList.size() - 1; idx >= 0; idx --) {
//			list.add(0, letterList.get(idx));
//		}
//		
//		String[] res = new String[logs.length];
//		return list.toArray(res);
//    }

	// ref: https://leetcode.com/problems/reorder-log-files/discuss/193872/Java-Nothing-Fancy-15-lines-5ms-all-clear.
	public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> myComp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1si = s1.indexOf(' ');
                int s2si = s2.indexOf(' ');
                char s1fc = s1.charAt(s1si+1);
                char s2fc = s2.charAt(s2si+1);
                
                if (s1fc <= '9') {
                    if (s2fc <= '9') return 0;
                    else return 1;
                }
                if (s2fc <= '9') return -1;
                
                int preCompute = s1.substring(s1si+1).compareTo(s2.substring(s2si+1));
                if (preCompute == 0) return s1.substring(0,s1si).compareTo(s2.substring(0,s2si));
                return preCompute;
            }
        };
        
        Arrays.sort(logs, myComp);
        return logs;
    }
}
