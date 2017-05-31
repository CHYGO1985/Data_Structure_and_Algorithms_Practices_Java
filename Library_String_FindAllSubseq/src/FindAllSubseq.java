import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author jingjiejiang
 * @history May 31, 2017
 */
public class FindAllSubseq {
	
	public static Set<String> getSubseqs(String s) {
        Set<String> res = new HashSet<>();
        if (s.length() == 0) {
             res.add("");
             return res;
        }
        Set<String> subRes = getSubseqs(s.substring(1));
        res.addAll(subRes);
        // add s.charAt(0) is crucial
        for (String seq : subRes) res.add(s.charAt(0) + seq);
        return res;
    }
}
