import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class GroupShiftedStrings {

	public List<List<String>> groupStrings(String[] strings) {
        // round 2: use less line implementation
        
        // round 1: sovled, 40m. 7ms, beat 46%
        // improve 1: without sorting, 5ms, beat 67.16%
        // improve 2: refactoring add ele to list: 4ms, beat 77% 
        // String used more time than StringBuilder
        // idea: method 1
        // 1. (sort will make it slow )must be the same length (when it is 1, then all the same group) --> sort the array 
        // (otherwise need to check length with strings in the map every time, worst case O(n^2) (none of repeat))
        // 2. match method: 
        // 1) check one by one, check chars in the same pos: val = (b + 26 - 1) % 26 , all have the same val
        // 2) use a map <pattern, index> (pattern: a***), pattern always start from a
        // 3) list to store result
        
        // *** java: (char)(cur - pattern) char + int = int, need to use(char)(char + int) = char
        // *** map.values())
        
        // more concise implementation use Map<String, List<String>>
        // ref:  https://discuss.leetcode.com/topic/35088/12-lines-java-solution-with-explanation
        /*
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs) {
            String key = "";
            char first = str.charAt(0);
            for(char c:str.toCharArray())
                key+=(c-first<0?c-first+26:c-first)+",";
            if(!map.containsKey(key))
                map.put(key,new ArrayList<String>());
            map.get(key).add(str);
        }
        for(String key:map.keySet())
            Collections.sort(map.get(key));
        return new ArrayList<List<String>>(map.values());
        */
        
        List<List<String>> list = new LinkedList<List<String>>();
        if (null == strings || 0 == strings.length) 
            return list;
        // (pattern, index) hashtable
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        /*
        // sort the array in ascending order
        Arrays.sort(strings, new Comparator<String>() {
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });
        */
        
        for (int i = 0; i < strings.length; i ++) {

            // conver the string to pattern : a***
            int shift = 0;
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < strings[i].length(); j ++) {
                char cur = strings[i].charAt(j);
                if (j == 0) 
                    shift = (cur - 'a' + 26) % 26;
                builder.append((char) ((cur - shift + 26) % 26));
            }
            
            String pattern = builder.toString();
            
            // if have new pattern add to map and add a new list item
            /*
            int index = map.getOrDefault(pattern, -1);
            List<String> tempList;
            if (index == -1) {
                tempList = new LinkedList<String>();
                tempList.add(strings[i]);
                list.add(tempList);
                map.put(pattern, list.size() - 1);
            }
            else {
            // if it is an old pattern, get the index and add to an existing list item
                tempList = list.get(index);
                tempList.add(strings[i]);
                // *** the tempList already exist, so use list.add() will create duplicate
            }
            */
            
            // refacoring to
            int index = map.getOrDefault(pattern, -1);
            List<String> tempList;
            if (index == -1) {
                tempList = new LinkedList<String>();
                list.add(tempList);
                map.put(pattern, list.size() - 1);
            }
            tempList = list.get(map.get(pattern));
            tempList.add(strings[i]);
        }
        
        return list;
    }
}
