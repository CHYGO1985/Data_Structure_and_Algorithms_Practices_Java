import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 
 * 187. Repeated DNA Sequences
 * 
 * @CHYGO1985
 * @history Oct 17, 2020
 * 
 */
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        
        List<String> list = new ArrayList<>();
        
        if (s.length() == 0) return list;

        int dnaLen = 10;
        Set<String> strSet = new HashSet<>();
        Set<String> resSet = new HashSet<>();

        // len 10, idx = 0, 0 + 10 = len, so <=
        for (int idx = 0; idx <= s.length() - dnaLen; idx ++) {

            String curDna = s.substring(idx, idx + dnaLen);
            if (!strSet.add(curDna)) 
                resSet.add(curDna);
        }

        for (String str : resSet) {
            list.add(str);
        }

        return list;
    }
}