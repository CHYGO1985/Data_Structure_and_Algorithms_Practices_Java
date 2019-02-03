package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author jingjiejiang Feb 3, 2019
 *
 */
public class ReorderLogFiles {
	public String[] reorderLogFiles(String[] logs) {
        // distinguish letter and digit
		// sort letters
		List<String> list = new ArrayList<>();
		List<String> letterList = new LinkedList<>();
		
		for (String log : logs) {
			String[] tmp = log.split(" ");
			if (tmp[1].matches("\\d+")) {
				list.add(log);
			} else {
				letterList.add(log);
			}
		}
        
		String[] letterLogs = new String[letterList.size()];
		letterLogs = letterList.toArray(letterLogs);
		Arrays.sort(letterLogs, (str1, str2) -> {
			str1 = str1.substring(str1.indexOf(" ") + 1);
			str2 = str2.substring(str2.indexOf(" ") + 1);
			return str1.compareTo(str2);
		});
		for (int idx = letterLogs.length - 1; idx >= 0; idx --) {
			list.add(0, letterLogs[idx]);
		}
		
		String[] res = new String[logs.length];
		return list.toArray(res);
    }
}
